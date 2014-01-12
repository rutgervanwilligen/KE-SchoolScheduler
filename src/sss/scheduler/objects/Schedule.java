package sss.scheduler.objects;

import java.util.ArrayList;

import sss.scheduler.objects.Lesson;

public class Schedule {
	
	protected ArrayList<Lesson> unallocatedLessons;
	protected ArrayList<Lesson> schedulingSet;
	protected ArrayList<Lesson> allocatedLessons;
	protected ArrayList<Lesson> unallocatableLessons;
	

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

	
	/**
	 * Constructor
	 */
	public Schedule () {
		allocatedLessons = new ArrayList<Lesson>();
		unallocatedLessons = new ArrayList<Lesson>();
		schedulingSet = new ArrayList<Lesson>();
		unallocatableLessons = new ArrayList<Lesson>();
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
	  	
	  	schedulingSet.add(lesson);
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
		
		lesson.setClassroom(classroom);
		lesson.allocateTimeslot(firstHour, secondHour);
		classroom.setToUnavailable(firstHour);
		classroom.setToUnavailable(secondHour);
		classInSchool.setToUnavailable(firstHour);
		classInSchool.setToUnavailable(secondHour);
		teacher.setToUnavailable(firstHour);
		teacher.setToUnavailable(secondHour);
		
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
		  	teacher.setToAvailable(hour);	
		}
	  	
	  	schedulingSet.add(lesson);
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
	
}
