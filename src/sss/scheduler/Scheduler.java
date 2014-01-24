package sss.scheduler;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import jeops.conflict.MRUConflictSet;
import jeops.conflict.PriorityConflictSet;
import sss.reasoner.ClassroomTimeslotAllocationKB;
import sss.reasoner.LessonSelectionKB;
import sss.reasoner.LessonSwapKB;
import sss.reasoner.ScheduleEvaluationKB;
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
	

	/*
	 * Getters
	 */
	public Schedule getSchedule() {
		return schedule;
	}
	
	
	/**
	 * Constructor
	 * @param hours
	 * @param subjects
	 * @param teachers
	 * @param classrooms
	 * @param classes
	 * @param subjectsClasses
	 * @param teachersClasses
	 */
	public Scheduler(ArrayList<LessonHour> hours, TreeMap<String, Subject> subjects, 
			TreeMap<String, Teacher> teachers, TreeMap<String, Classroom> classrooms, 
			TreeMap<String, ClassInSchool> classes, SubjectClassAllocation subjectsClasses, 
			TeacherClassAllocation teachersClasses) {
		schedule = new Schedule();
		Scheduler.hours = hours;
		this.subjects = subjects;
		this.teachers = teachers;
		this.classrooms = classrooms;
		this.classes = classes;
		this.subjectsClasses = subjectsClasses;
		this.teachersClasses = teachersClasses;
	}
	
	/**
	 * Main scheduling loop as found in the knowledge model.
	 */
	public void createSchedule() {
		int swapCounter = 0;
		
		System.out.println("Starting schedule creation");
		addAllLessonsToSchedule();
		
		createLessonSelectionKB();
		createLessonAllocationKB();
		createLessonSwapKB();
		createScheduleEvaluationKB();

		while (schedule.containsUnallocatedLessons()) {
			selectLessonToSchedule();
			allocateLessonToClassroomAndTimeslot();
			
			while (schedule.getSchedulingSet().size() > 0) {
				System.out.println("Swapping..");
				swapCounter++;
				
				schedule.markUnallocatableLessons();
				allocateLessonsThroughSwap();
			}
		}
		
		evaluateSchedule();

		System.out.println("\nTadadadaaaaaahh, results!\n");
		System.out.println("Number of swap attempts: " + swapCounter);
		System.out.println("Unallocatable lessons");
		for (Lesson lesson : schedule.getUnallocatableLessons()) {
			System.out.println(lesson.getClassInSchool().getName() + ", " + lesson.getSubject().getName() + ", " + lesson.getTeacher().getName());
		}
		System.out.println("Unallocated lessons");
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			System.out.println(lesson.getClassInSchool().getName() + ", " + lesson.getSubject().getName() + ", " + lesson.getTeacher().getName());
		}
		System.out.println("Scheduling set");
		for (Lesson lesson : schedule.getSchedulingSet()) {
			System.out.println(lesson.getClassInSchool().getName() + ", " + lesson.getSubject().getName() + ", " + lesson.getTeacher().getName());
		}
		System.out.println();
		System.out.println("The schedule has a rating of " + schedule.getRating() + ".");
		System.out.println();
	}
	
	
	protected void createScheduleEvaluationKB() {
		scheduleEvaluationKB = new ScheduleEvaluationKB(new MRUConflictSet()); //TODO Conflict set?
	}
	
	protected void evaluateSchedule() {
		scheduleEvaluationKB.flush();
		scheduleEvaluationKB.tell(schedule);
		
		for (Entry<String, Teacher> entry : teachers.entrySet()) {
			scheduleEvaluationKB.tell(entry.getValue());
		}
		
		for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
			scheduleEvaluationKB.tell(entry.getValue());
		}
		
		for (Lesson lesson : schedule.getAllocatedLessons()) {
			scheduleEvaluationKB.tell(lesson);
		}

		for (LessonHour hour : hours) {
			scheduleEvaluationKB.tell(hour);
		}
		
		scheduleEvaluationKB.run();
	}
	
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
	
	protected void createLessonSwapKB() {
		lessonSwapKB = new LessonSwapKB(new PriorityConflictSet()); //TODO priority conflict set?
		
		// Add classrooms to KB
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			lessonAllocationKB.tell(entry.getValue());
		}
		
		// Add hours to KB
		for (LessonHour hour : hours) {
			lessonAllocationKB.tell(hour);
		}
	}
	
	protected void createLessonSelectionKB() {
		lessonSelectionKB = new LessonSelectionKB(new PriorityConflictSet());

		lessonSelectionKB.tell(this);
		lessonSelectionKB.tell(schedule);
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			lesson.setAvailabilityCount(this.getAvailabilityCountForLesson(lesson));
			lessonSelectionKB.tell(lesson);
		}
	}
	
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
		}
		lessonSelectionKB.retract(schedule);
		lessonSelectionKB.tell(schedule);
		lessonSelectionKB.run();
	}
	
	public void allocateLessonToClassroomAndTimeslot() {
		// Add lessons from schedule's conflict set to KB
		for (Lesson lesson : schedule.getSchedulingSet()) {
			lessonAllocationKB.tell(lesson);
		}
		lessonAllocationKB.run();
		// Lesson from schedule's "conflict set" is now allocated to classroom and time slot
	}	
	
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
}
