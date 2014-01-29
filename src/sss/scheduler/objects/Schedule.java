package sss.scheduler.objects;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import sss.reasoner.penaltyObjects.Penalty;
import sss.scheduler.actions.MoveLessonAction;
import sss.scheduler.actions.ScheduleAction;
import sss.scheduler.objects.Lesson;
import sss.scheduler.properties.Availability;

public class Schedule extends Observable {
	
	protected ArrayList<Lesson> unallocatedLessons;
	protected ArrayList<Lesson> schedulingSet;
	protected ArrayList<Lesson> allocatedLessons;
	protected ArrayList<Lesson> unallocatableLessons;
	
	private int rating;
	private ArrayList<Penalty> penalties;
	private Stack<ScheduleAction> actionStack;

	/*
	 * Getters
	 */
	public ArrayList<Lesson> getSchedulingSet() {
		return schedulingSet;
	}
	
	public ArrayList<Lesson> getUnallocatableLessons() {
		return unallocatableLessons;
	}
	
	public ArrayList<Lesson> getUnallocatedLessons() {
		return unallocatedLessons;
	}
	
	public ArrayList<Lesson> getAllocatedLessons() {
		return allocatedLessons;
	}

	public int getRating() {
		return rating;
	}
	
	public double getProgress() {
		return ((1. * allocatedLessons.size()) / (allocatedLessons.size() + unallocatableLessons.size() + unallocatedLessons.size() + schedulingSet.size())) * 100;
	}

	public ArrayList<Penalty> getPenalties() {
		return penalties;
	}
	
	/*
	 * Setters
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Constructor
	 */
	public Schedule () {
		allocatedLessons = new ArrayList<Lesson>();
		unallocatedLessons = new ArrayList<Lesson>();
		schedulingSet = new ArrayList<Lesson>();
		unallocatableLessons = new ArrayList<Lesson>();
		
		penalties = new ArrayList<Penalty>();
		actionStack = new Stack<ScheduleAction>();
		
		setRating(0);
	}
	
	/**
	 * Add lesson to be allocated to the schedule.
	 * @param lesson Lesson to add to the schedule.
	 */
	public void addLesson(Lesson lesson) {
		unallocatedLessons.add(lesson);
	}

	/**
	 * Remove unscheduled lesson from the schedule.
	 * @param lesson Unscheduled lesson to remove from the schedule.
	 */
	public void removeUnallocatedLesson(Lesson lesson) {
		unallocatedLessons.remove(lesson);
	}
	
	/**
	 * Remove scheduled lesson from the schedule.
	 * @param lesson Scheduled lesson to remove from the schedule.
	 */
	public void removeAllocatedLesson(Lesson lesson) {
		allocatedLessons.remove(lesson);
	}
	
	/**
	 * Returns whether a lesson object is allocated.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the lesson is allocated.
	 */
	public boolean containsAllocatedLesson(Lesson lesson) {
		return allocatedLessons.contains(lesson);
	}
	
	/**
	 * Returns whether a lesson object is unallocatable.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the lesson is unallocatable.
	 */
	public boolean containsUnallocatableLesson(Lesson lesson) {
		return unallocatableLessons.contains(lesson);
	}
	
	/**
	 * Returns whether a lesson object is present but unallocated.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the lesson is allocated.
	 */
	public boolean containsUnallocatedLesson(Lesson lesson) {
		return unallocatedLessons.contains(lesson);
	}
	
	/**
	 * Returns whether a lesson object is present in the scheduling set.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the lesson is in the scheduling set.
	 */
	public boolean containsLessonInSchedulingSet(Lesson lesson) {
		return schedulingSet.contains(lesson);
	}
	
	/**
	 * Returns whether the schedule contains unallocated lessons.
	 * @return Boolean value indicating whether the schedule contains unallocated lessons.
	 */
	public boolean containsUnallocatedLessons() {
		return !unallocatedLessons.isEmpty();
	}
	
	/**
	 * Add a lesson to the scheduling set.
	 * @param Lesson to add to scheduling set.
	 */
	public void addToSchedulingSet(Lesson lesson) {
		unallocatedLessons.remove(lesson);
		schedulingSet.add(lesson);
	}

	/**
	 * Check whether the scheduling set is empty.
	 * @return Returns whether the scheduling set is empty.
	 */
	public boolean schedulingSetIsEmpty() {
		return schedulingSet.isEmpty();
	}
	
	/**
	 * Allocate a SingleHourLesson present in the scheduling set to a classroom and hour.
	 * @param lesson Single hour lesson object to allocate.
	 * @param classroom Classroom object to allocate the lesson to.
	 * @param hour Hour to allocate the lesson to.
	 */
	public void scheduleSingleHourLesson(SingleHourLesson lesson, Classroom classroom, ClassInSchool classInSchool, Teacher teacher, LessonHour hour) {
	  	schedulingSet.remove(lesson);
	  	unallocatableLessons.remove(lesson);
	  	unallocatedLessons.remove(lesson);
	  	
		lesson.setClassroom(classroom);
		lesson.allocateTimeslot(hour);
	  	classroom.setToUnavailable(hour);
	  	classInSchool.setToUnavailable(hour);
	  	teacher.setToUnavailable(hour);
	  	
		allocatedLessons.add(lesson);
	}
	
	/**
	 * Deschedules a lesson. Also takes into account the availability of teacher, classroom, etc.
	 * @param lesson
	 */
	protected void descheduleSingleHourLesson(SingleHourLesson lesson) {
		allocatedLessons.remove(lesson);
		
		Classroom classroom = lesson.removeClassroom();
		Teacher teacher = lesson.getTeacher();
		ClassInSchool classInSchool = lesson.getClassInSchool();
		LessonHour hour = lesson.unallocateTimeslot(1);
	  	classroom.setToAvailable(hour);
	  	classInSchool.setToAvailable(hour);
	  	teacher.setToAvailable(hour);
	  	
	  	unallocatedLessons.add(lesson);
	}
	
	public void scheduleLesson(Lesson lesson, Classroom classroom, ClassInSchool classInSchool, Teacher teacher, LessonHour firstHour) {
		if (lesson instanceof SingleHourLesson) {
			scheduleSingleHourLesson( (SingleHourLesson) lesson, classroom, classInSchool, teacher, firstHour);
		} else if (lesson instanceof DoubleHourLesson) {
			if (firstHour.hasNextHour()) {
				scheduleDoubleHourLesson( (DoubleHourLesson) lesson, classroom, classInSchool, teacher, firstHour, firstHour.getNextHour());
			} else {
				System.out.println("ScheduleLesson error: trying to schedule double hour lesson but hour has no next hour");
				System.exit(1);
			}
		} else {
			System.out.println("ScheduleLesson error: Input lesson not sane");
			System.exit(1);
		}
		
		informObservers();
	}
	
	private void informObservers() {
        setChanged();
		notifyObservers();
	}

	/**
	 * Allocate a DoubleHourLesson present in the scheduling set to a classroom and hour.
	 * @param lesson Double hour lesson object to allocate.
	 * @param classroom Classroom object to allocate the lesson to.
	 * @param firstHour First hour to allocate the lesson to.
	 * @param secondHour Second hour to allocate the lesson to.
	 */
	public void scheduleDoubleHourLesson(DoubleHourLesson lesson, Classroom classroom, ClassInSchool classInSchool, Teacher teacher, LessonHour firstHour, LessonHour secondHour) {
		schedulingSet.remove(lesson);
		unallocatableLessons.remove(lesson);
		unallocatedLessons.remove(lesson);
		
		lesson.setClassroom(classroom);
		lesson.allocateTimeslot(firstHour, secondHour);
		classroom.setToUnavailable(firstHour);
		classroom.setToUnavailable(secondHour);
		classInSchool.setToUnavailable(firstHour);
		classInSchool.setToUnavailable(secondHour);
		teacher.setScheduled(firstHour, Availability.UNAVAILABLE)
				.setScheduled(secondHour, Availability.UNAVAILABLE);
		
		allocatedLessons.add(lesson);
	}

	/**
	 * Moves all lessons that are still in the schedulingset to unallocatableLessons.
	 */
	public void markUnallocatableLessons() {
		unallocatableLessons.addAll(schedulingSet);
		schedulingSet.clear();
	}

	/**
	 * Returns all unallocatable lessons to unallocated lessons.
	 */
	public void resetUnallocatableLessons() {
		unallocatedLessons.addAll(unallocatableLessons);
		unallocatableLessons.clear();
	}
	
	/**
	 * Deschedules a double lesson. Also takes into account the availability of teacher, classroom, etc.
	 * @param lesson
	 */
	protected void descheduleDoubleHourLesson(DoubleHourLesson lesson) {
		allocatedLessons.remove(lesson);
		
		Classroom classroom = lesson.removeClassroom();
		Teacher teacher = lesson.getTeacher();
		ClassInSchool classInSchool = lesson.getClassInSchool();
		
		for (int i = 1; i <= 2; i++) {
			LessonHour hour = lesson.unallocateTimeslot(i);
		  	classroom.setToAvailable(hour);
		  	classInSchool.setToAvailable(hour);
			teacher.setScheduled(hour, Availability.AVAILABLE);
		}
	  	
	  	unallocatedLessons.add(lesson);
	}
	
	/**
	 * Deschedule the given lesson.
	 * @param lesson Lesson to deschedule
	 */
	public void descheduleLesson(Lesson lesson) {
		if (lesson.isDoubleHour()) {
			descheduleDoubleHourLesson((DoubleHourLesson)lesson);
		} else {
			descheduleSingleHourLesson((SingleHourLesson)lesson);
		}
	}
	
	/**
	 * Swap the timeslots of lesson 1 and lesson 2.
	 * @param lesson1 Lesson to swap
	 * @param lesson2 Lesson to swap
	 */
	public void swapLessons(Lesson lesson1, Lesson lesson2) {
		LessonHour newFirstHourLesson1 = lesson2.getHour();
		LessonHour newFirstHourLesson2 = lesson1.getHour();
		
		Classroom classroom1 = lesson1.getClassroom();
		Classroom classroom2 = lesson2.getClassroom();

		descheduleLesson(lesson1);
		descheduleLesson(lesson2);
		
		if (lesson1.isDoubleHour()) {
			LessonHour newSecondHourLesson1 = newFirstHourLesson1.getNextHour();
			scheduleDoubleHourLesson((DoubleHourLesson)lesson1, classroom1, lesson1.getClassInSchool(), lesson1.getTeacher(), newFirstHourLesson1, newSecondHourLesson1);
		} else {
			scheduleSingleHourLesson((SingleHourLesson)lesson1, classroom1, lesson1.getClassInSchool(), lesson1.getTeacher(), newFirstHourLesson1);
		}
		
		if (lesson2.isDoubleHour()) {
			LessonHour newSecondHourLesson2 = newFirstHourLesson2.getNextHour();
			scheduleDoubleHourLesson((DoubleHourLesson)lesson2, classroom2, lesson2.getClassInSchool(), lesson2.getTeacher(), newFirstHourLesson2, newSecondHourLesson2);
		} else {
			scheduleSingleHourLesson((SingleHourLesson)lesson2, classroom2, lesson2.getClassInSchool(), lesson2.getTeacher(), newFirstHourLesson2);
		}
	}
	
	/**
	 * Move lesson to new timeslot and classroom.
	 * @param lesson Lesson to swap
	 */
	public void moveLesson(Lesson lesson, LessonHour newLessonHour, Classroom newClassroom) {
		Classroom oldClassroom = lesson.getClassroom();
		LessonHour oldLessonHour = lesson.getHour();
		Teacher teacher = lesson.getTeacher();
		ClassInSchool classInSchool = lesson.getClassInSchool();

		descheduleLesson(lesson);
		scheduleLesson(lesson, newClassroom, classInSchool, teacher, newLessonHour);
		
		actionStack.push(new MoveLessonAction(lesson, oldLessonHour, oldClassroom));
	}
	
	/**
	 * Returns the lowest availability count.
	 * @return Lowest availability count.
	 */
	public int lowestAvailabilityCount() {
		int result = Integer.MAX_VALUE;
		
		for (Lesson lesson : unallocatedLessons) {
			if (lesson.getAvailabilityCount() < result) {
				result = lesson.getAvailabilityCount();
			}
		}
		
		return result;
	}

	/**
	 * Returns whether there is exactly one unallocated lesson with the lowest availability count.
	 * @return Truth value indicating if there is exactly one unallocated lesson with the lowest availability count.
	 */
	public boolean singleLowestAvailabilityCount() {
		int lowestCount = lowestAvailabilityCount();
		int nrOfLessons = 0;
		
		for (Lesson lesson : unallocatedLessons) {
			if (lesson.getAvailabilityCount() == lowestCount) {
				
				nrOfLessons++;
			}
		}
		
		return (nrOfLessons == 1);
	}
	
	/**
	 * Returns whether a teacher already has given lessons in a classroom on a certain day, given an hour.
	 * @param teacher Teacher to check
	 * @param classroom Classroom to check
	 * @param lessonHour The LessonHour object to check
	 * @return Truth value indicating if the teacher is scheduled in the Classroom on the day of the LessonHour object
	 */
	public boolean teacherAlreadyScheduledInClassroomOnWeekday(Teacher teacher, Classroom classroom, LessonHour hourToCheck) {
		for (Lesson lesson : allocatedLessons) {
			if (!(lesson.getTeacher().equals(teacher)) ||
				!(lesson.getHour().getWeekday() == hourToCheck.getWeekday())) {
				continue;
			}
			if (lesson.getClassroom().equals(classroom)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean teacherAlreadyScheduledInClassroomRightBeforeOrAfter(Teacher teacher, Classroom classroom, LessonHour hourToCheck) {
		for (Lesson lesson : allocatedLessons) {
			if (!(lesson.getTeacher().equals(teacher)) ||
				!(lesson.getHour().getWeekday() == hourToCheck.getWeekday()) ||
				!(lesson.getClassroom().equals(classroom))) {
				continue;
			}
			
			if (Math.abs(lesson.getHour().getHour() - hourToCheck.getHour()) == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean subjectAlreadyAllocatedToClassOnWeekday(Subject subject, LessonHour hourToCheck, ClassInSchool classInSchool) {
		for (Lesson lesson : allocatedLessons) {
			if ((lesson.getSubject().equals(subject)) &&
				(classInSchool.equals(lesson.getClassInSchool())) &&
				(lesson.getHour().getWeekday() == hourToCheck.getWeekday())) {
				return true;
			}
		}
		return false;
	}
	
	public int numberOfClassesWithoutHomeworkOnWeekday(ClassInSchool classInSchool, LessonHour hour) {
		int result = 0;
		
		for (Lesson lesson : allocatedLessons) {
			if (lesson.getClassInSchool().equals(classInSchool) &&
					lesson.getHour().getWeekday() == hour.getWeekday() &&
					lesson.getSubject().requiresHomework()) {
				result ++;
			}
		}
		return result;
	}
	
	public boolean noClassesWithoutHomeworkOnWeekday(ClassInSchool classInSchool, LessonHour hour) {
		return numberOfClassesWithoutHomeworkOnWeekday(classInSchool, hour) == 0;
	}
	
	public void addToRating(int addition) {
		rating += addition;

		informObservers();
	}

	public boolean isPreferredAt(Lesson lesson, LessonHour firstHour) {
		if (lesson instanceof SingleHourLesson) {
			return firstHour.isPreferredToTeachOn();
		} else if (lesson instanceof DoubleHourLesson) {
			return firstHour.preferredForDoubleHour();
		} else {
			System.out.println("isPreferredAt error: input lesson ot sane");
			System.exit(1);
			return false;
		}
	}
	
	public void addPenaltyObject(Penalty penaltyObject, int penalty) {
		penaltyObject.penalty = penalty;
		penalties.add(penaltyObject);
		
		rating += penalty;
	}

	public ArrayList<Penalty> getAndResetPenalties() {
		ArrayList<Penalty> result = penalties;
		penalties = new ArrayList<Penalty>();
		
		return result;
	}
	
	public void revertLastAction() {
		System.out.println("\n---------------- Reverting! ----------------\n");
		if (! actionStack.isEmpty()) {
			ScheduleAction action = actionStack.pop();
			
			if (action instanceof MoveLessonAction) {
				MoveLessonAction moveAction = (MoveLessonAction) action;
				moveLesson(moveAction.lesson, moveAction.lessonHour, moveAction.classroom);
			}
		}
	}
	
	public void revertActions() {
		System.out.println("\n---------------- Reverting! ----------------\n");
		while (! actionStack.empty()) {
			ScheduleAction action = actionStack.pop();
			
			if (action instanceof MoveLessonAction) {
				MoveLessonAction moveAction = (MoveLessonAction) action;
				moveLesson(moveAction.lesson, moveAction.lessonHour, moveAction.classroom);
				actionStack.pop();
			}
		}
	}

	public void removeActionHistory() {
		actionStack.clear();
	}
	
}
