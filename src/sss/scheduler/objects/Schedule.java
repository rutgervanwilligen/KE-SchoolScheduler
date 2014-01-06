package sss.scheduler.objects;

import java.util.ArrayList;

import sss.scheduler.objects.Lesson;

public class Schedule {
	
	private ArrayList<Lesson> allocatedLessons;
	private ArrayList<Lesson> unallocatedLessons;
	private ArrayList<Lesson> lessonsToAllocate;

	public Schedule () {
		allocatedLessons = new ArrayList<Lesson>();
		unallocatedLessons = new ArrayList<Lesson>();
		lessonsToAllocate = new ArrayList<Lesson>();
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
		return lessonsToAllocate.contains(lesson);
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
		lessonsToAllocate.add(lesson);
	}

	/**
	 * Check whether the scheduling set is empty.
	 * @return Returns whether the scheduling set is empty.
	 */
	public boolean schedulingSetIsEmpty() {
		return lessonsToAllocate.isEmpty();
	}
	
	/**
	 * Returns the lessons in the scheduling set.
	 * @return ArrayList of lessons in the scheduling set.
	 */
	public ArrayList<Lesson> getSchedulingSet() {
		return lessonsToAllocate;
	}
	
	/**
	 * Returns the unallocated lessons in the schedule.
	 * @return ArrayList of unallocated lessons.
	 */
	public ArrayList<Lesson> getUnallocatedLessons() {
		return unallocatedLessons;
	}
	
	/**
	 * Returns the allocated lessons in the schedule.
	 * @return ArrayList of allocated lessons.
	 */
	public ArrayList<Lesson> getAllocatedLessons() {
		return allocatedLessons;
	}
	
	/**
	 * Allocate a SingleHourLesson present in the scheduling set to a classroom and hour.
	 * @param lesson Single hour lesson object to allocate.
	 * @param classroom Classroom object to allocate the lesson to.
	 * @param hour Hour to allocate the lesson to.
	 */
	public void scheduleSingleHourLesson(SingleHourLesson lesson, Classroom classroom, LessonHour hour) {
		lessonsToAllocate.remove(lesson);
		lesson.setClassroom(classroom);
		lesson.allocateTimeslot(hour);
		allocatedLessons.add(lesson);
	}
	
	/**
	 * Allocate a DoubleHourLesson present in the scheduling set to a classroom and hour.
	 * @param lesson Double hour lesson object to allocate.
	 * @param classroom Classroom object to allocate the lesson to.
	 * @param firstHour First hour to allocate the lesson to.
	 * @param secondHour Second hour to allocate the lesson to.
	 */
	public void scheduleDoubleHourLesson(DoubleHourLesson lesson, Classroom classroom, LessonHour firstHour, LessonHour secondHour) {
		lessonsToAllocate.remove(lesson);
		lesson.setClassroom(classroom);
		lesson.allocateTimeslot(firstHour, secondHour);
		allocatedLessons.add(lesson);
	}
	
}
