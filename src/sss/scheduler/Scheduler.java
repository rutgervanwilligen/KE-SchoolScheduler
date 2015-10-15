package sss.scheduler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import jeops.conflict.MRUConflictSet;
import jeops.conflict.PriorityConflictSet;
import sss.reasoner.ClassroomTimeslotAllocationKB;
import sss.reasoner.LessonSelectionKB;
import sss.reasoner.LessonSwapKB;
import sss.reasoner.ScheduleEvaluationKB;
import sss.reasoner.ScheduleOptimizationKB;
import sss.reasoner.penaltyObjects.Penalty;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.DoubleHourLesson;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.SingleHourLesson;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class Scheduler {
	
	protected Schedule schedule;
	public static ArrayList<LessonHour> hours;
	protected TreeMap<String, Subject> subjects;
	protected TreeMap<String, Classroom> classrooms;
	protected TreeMap<String, Teacher> teachers;
	protected TreeMap<String, ClassInSchool> classes;
	protected SubjectClassAllocation subjectsClasses;
	protected TeacherClassAllocation teachersClasses;

	protected LessonSelectionKB lessonSelectionKB;
	protected ClassroomTimeslotAllocationKB lessonAllocationKB;
	protected LessonSwapKB lessonSwapKB;
	protected ScheduleEvaluationKB scheduleEvaluationKB;
	private ScheduleOptimizationKB scheduleOptimizationKB;
	private boolean running;
	
	/*
	 * Getters
	 */
	public Schedule getSchedule() {
		return schedule;
	}
	
	/**
	 * Constructor
	 */
	public Scheduler() {
		schedule = new Schedule();
	}
	
	/**
	 * Main scheduling loop as found in the knowledge model.
	 */
	public void createSchedule() {
		int oldRating, newRating, successfullSwaps;
		running = true;
		
		System.out.println();
		System.out.println("Setting up knowledge bases...");
		addAllLessonsToSchedule();
		
		// Create all required knowledge bases
		createLessonSelectionKB();
		createLessonAllocationKB();
		createLessonSwapKB();
		createScheduleEvaluationKB();
		createScheduleOptimizationKB();
		
		// Build initial schedule
		System.out.println("Creating initial schedule...");
		scheduleUnallocatableLessons();
		
		/* Start loop to optimize schedule. The loop evaluates the current schedule and retrieves
		all penalties. Then it loops through the penalties until it finds an optimization that
		raises the rating. Then it retrieves the new set of penalties and starts over. */
		System.out.print("\nDone with first schedule version, performing optimization process...");
		newRating = schedule.getRating();
		successfullSwaps = 0;
		ArrayList<Penalty> penalties;
		do {
			schedule.getAndResetPenalties();
			evaluateSchedule();
			penalties = schedule.getAndResetPenalties();
			Collections.sort(penalties);
			
			do {
				if (! running) {
					break;
				}

				schedule.getAndResetPenalties();
				evaluateSchedule();
				oldRating = schedule.getRating();
				
				optimizeSchedule(penalties.remove(0));

				schedule.getAndResetPenalties();
				evaluateSchedule();
				newRating = schedule.getRating();
				
				if (newRating < oldRating) {
					System.out.print("\nDid something stupid there, reverting...");
					schedule.revertActions();
					System.out.print("..and resuming..");
				} else if (newRating > oldRating) {
					System.out.print(".");
					successfullSwaps++;
				}
				schedule.removeActionHistory();
			} while (newRating == oldRating && ! penalties.isEmpty());
			
			// Using some interval, try to schedule unallocateable lessons if there are still any present.
			if (successfullSwaps >= 25 && schedule.containsUnallocatableLessons()) {
				System.out.println("\nRetrying to schedule unallocatable lessons...");
				
				schedule.resetUnallocatableLessons();
				scheduleUnallocatableLessons();
				successfullSwaps = 0;
				
				System.out.print("Resuming optimization process...");
			}
		} while (running);

		// Print termination text.
		printTerminatedText();
	}
	
	/**
	 * Print termination text.
	 */
	protected void printTerminatedText() {
		System.out.println("\n\nTadadadaaaaaahh, results!\n");
		System.out.println("Unallocatable lessons:");
		for (Lesson lesson : schedule.getUnallocatableLessons()) {
			System.out.println(lesson.getClassInSchool().getName() + ", " + lesson.getSubject().getName() + ", " + lesson.getTeacher().getName());
		}
		System.out.println("Unallocated lessons:");
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			System.out.println(lesson.getClassInSchool().getName() + ", " + lesson.getSubject().getName() + ", " + lesson.getTeacher().getName());
		}
		System.out.println();
		System.out.println("The schedule has a rating of " + schedule.getRating() + ".");
		System.out.println();
	}

	/**
	 * While there are still unallocated lessons tries to select and allocate a lesson. If
	 * unallocatable lessons are found, it tries to find a swap to make it allocatable.
	 */
	protected void scheduleUnallocatableLessons() {
		while (schedule.containsUnallocatedLessons() && running) {
			selectLessonToSchedule();
			allocateLessonToClassroomAndTimeslot();
			
			while (schedule.getSchedulingSet().size() > 0 && running) {
				schedule.markUnallocatableLessons();
				allocateLessonsThroughSwap();
			}
		}
	}

	/**
	 * Calls the schedulOptimizationKB and tries to find an optimization for the given penalty.
	 * @param penalty
	 */
	private void optimizeSchedule(Penalty penalty) {
		scheduleOptimizationKB.flush();
		scheduleOptimizationKB.tell(schedule);

		for (LessonHour hour : hours) {
			scheduleOptimizationKB.tell(hour);
		}
		
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			scheduleOptimizationKB.tell(entry.getValue());
		}
		
		for (Entry<String, Teacher> entry : teachers.entrySet()) {
			scheduleOptimizationKB.tell(entry.getValue());
		}
		
		for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
			scheduleOptimizationKB.tell(entry.getValue());
		}
		
		for (Lesson lesson : schedule.getAllocatedLessons()) {
			scheduleOptimizationKB.tell(lesson);
		}

		scheduleOptimizationKB.tell(penalty);
		scheduleOptimizationKB.run();
		scheduleEvaluationKB.retract(penalty);
	}
	
	/**
	 * Updates the scheduleEvaluationKB object and call it to evaluate the current schedule.f
	 */
	protected void evaluateSchedule() {
		schedule.setRating(0);
		
		scheduleEvaluationKB.flush();
		scheduleEvaluationKB.tell(schedule);

		for (LessonHour hour : hours) {
			scheduleEvaluationKB.tell(hour);
		}
		
		for (Entry<String, Teacher> entry : teachers.entrySet()) {
			scheduleEvaluationKB.tell(entry.getValue());
		}
		
		for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
			scheduleEvaluationKB.tell(entry.getValue());
		}
		
		for (Lesson lesson : schedule.getAllocatedLessons()) {
			scheduleEvaluationKB.tell(lesson);
		}
		
		scheduleEvaluationKB.run();
	}
	
	/**
	 * Updates lessonSwapKB object and runs it to find a swap for unallocatable lessons.
	 */
	protected void allocateLessonsThroughSwap() {
		lessonSwapKB.flush();
		lessonSwapKB.tell(schedule);
		
		for (Lesson lesson : schedule.getUnallocatableLessons()) {
			lessonSwapKB.tell(lesson);
		}
		
		for (Lesson lesson : schedule.getAllocatedLessons()) {
			lessonSwapKB.tell(lesson);
		}
		
		lessonSwapKB.run();
	}

	/**
	 * Create schedul evaluation KB.
	 */
	protected void createScheduleEvaluationKB() {
		scheduleEvaluationKB = new ScheduleEvaluationKB(new MRUConflictSet());
	}
	
	/**
	 * Creates schedules optimization KB.
	 */
	protected void createScheduleOptimizationKB() {
		scheduleOptimizationKB = new ScheduleOptimizationKB(new PriorityConflictSet());
	}
	
	/**
	 * Creates the lesson swap KB.
	 */
	protected void createLessonSwapKB() {
		lessonSwapKB = new LessonSwapKB(new PriorityConflictSet());
		
		// Add classrooms to KB
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			lessonAllocationKB.tell(entry.getValue());
		}
		
		// Add hours to KB
		for (LessonHour hour : hours) {
			lessonAllocationKB.tell(hour);
		}
	}
	
	/**
	 * Creates the lesson selection KB.
	 */
	protected void createLessonSelectionKB() {
		lessonSelectionKB = new LessonSelectionKB(new PriorityConflictSet());

		lessonSelectionKB.tell(this);
		lessonSelectionKB.tell(schedule);
	}
	
	/**
	 * Creates the lesson allocation KB.
	 */
	protected void createLessonAllocationKB() {
		lessonAllocationKB = new ClassroomTimeslotAllocationKB();
		
		// Add schedule to KB
		lessonAllocationKB.tell(schedule);
		
		// Add classrooms to KB
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			lessonAllocationKB.tell(entry.getValue());
		}
		
		// Add hours to KB
		for (LessonHour hour : hours) {
			lessonAllocationKB.tell(hour);
		}
	}
	
	public void selectLessonToSchedule() {
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			lesson.setAvailabilityCount(this.getAvailabilityCountForLesson(lesson));
			lessonSelectionKB.tell(lesson);
		}
		lessonSelectionKB.retract(schedule);
		lessonSelectionKB.tell(schedule);
		lessonSelectionKB.run();
	}
	
	/**
	 * Updates the lessonAllocationKB and runs it to allocates a classroom
	 * and timeslot for a lesson.
	 */
	public void allocateLessonToClassroomAndTimeslot() {
		// Add lessons from schedule's conflict set to KB
		for (Lesson lesson : schedule.getSchedulingSet()) {
			lessonAllocationKB.tell(lesson);
		}
		lessonAllocationKB.run();
		// Lesson from schedule's "conflict set" is now allocated to classroom and time slot
	}	
	
	/**
	 * Using the subjects and classes sets, generates all required lessons
	 * that are to be scheduled.
	 */
	public void addAllLessonsToSchedule() {
		for (Entry<String, Subject> subjectEntry : subjects.entrySet()) {
			for (Entry<String, ClassInSchool> classEntry : classes.entrySet()) {
				Subject s = subjectEntry.getValue();
				ClassInSchool c = classEntry.getValue();
				Teacher t = teachersClasses.getTeacher(s, c);
				
				String[] classNeeds = subjectsClasses.getHours(s, c);
								
				for (String string : classNeeds) {
					parseAndAddLesson(string, s, c, t);
				}
			}
		}
	}

	/**
	 * Adds one particular lesson that complies to the given parameters
	 * @param lessonString String describing the amount of lessons.
	 * @param s Subject
	 * @param c ClassInSchool
	 * @param t Teacher
	 */
	public void parseAndAddLesson (String lessonString, Subject s, ClassInSchool c, Teacher t) {
		int nHours = Character.getNumericValue(lessonString.charAt(0));

		if (nHours == 0) { // No lesson object created
			return;
		}
				
		boolean needsComputerRoom = false;
		boolean allowedInGeneralRoom = false;
		
		if (lessonString.length() > 1) {
			String facility = lessonString.substring(1);
			if (facility.equals("C")) {
				needsComputerRoom = true;
			} else if (facility.equals("ALG")) {
				allowedInGeneralRoom = true;
			} else {
				System.out.println("Input not sane -- String mismatch, ALG or C not read");
				System.exit(1);
			}
		}

		if (nHours == 1) {
			schedule.addLesson(new SingleHourLesson(s, t, c, allowedInGeneralRoom, needsComputerRoom));
		} else if (nHours == 2) {
			schedule.addLesson(new DoubleHourLesson(s, t, c, allowedInGeneralRoom, needsComputerRoom));
		} else {
			System.out.println("Input not sane: misread nHours");
			System.exit(1);
		}
	}
	
	/**
	 * Returns the amount of available timeslot combinations for the given lesson.
	 * @param lesson
	 * @return
	 */
	public int getAvailabilityCountForLesson(Lesson lesson) {
		int availabilityCount = 0;

		Teacher teacher = lesson.getTeacher();
		ClassInSchool classInSchool = lesson.getClassInSchool();
					
		for (int i = 0; i < hours.size(); i++) {
			
			LessonHour hour = hours.get(i);
			
			if (!teacher.isAvailable(hour, lesson) || !classInSchool.isAvailable(hour, lesson)) {
				continue;
			}
			
			for (Entry<String, Classroom> entry : classrooms.entrySet()) {
				Classroom classroom = entry.getValue();
				if (classroom.isAvailable(hour, lesson) && classroom.isSuitedFor(lesson)) {
					availabilityCount ++;
				}
			}
		}
		return availabilityCount;
	}

	/**
	 * Set all input data.
	 * @param hours
	 * @param subjects
	 * @param teachers
	 * @param classrooms
	 * @param classes
	 * @param subjectsClasses
	 * @param teachersClasses
	 */
	public void setData(ArrayList<LessonHour> hours, TreeMap<String, Subject> subjects, 
			TreeMap<String, Teacher> teachers, TreeMap<String, Classroom> classrooms, 
			TreeMap<String, ClassInSchool> classes, SubjectClassAllocation subjectsClasses, 
			TeacherClassAllocation teachersClasses) {
		Scheduler.hours = hours;
		this.subjects = subjects;
		this.teachers = teachers;
		this.classrooms = classrooms;
		this.classes = classes;
		this.subjectsClasses = subjectsClasses;
		this.teachersClasses = teachersClasses;
	}

	/**
	 * Sets running to false in order for the scheduling loop to stop.
	 */
	public void stopScheduling() {
		running = false;
	}

	/**
	 * Returns if scheduler is runnning or not.
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
}
