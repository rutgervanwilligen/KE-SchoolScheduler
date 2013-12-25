package sss.scheduler.objects;

import java.util.ArrayList;

import sss.scheduler.objects.Lesson;

public class Schedule {
	
	private ArrayList<Lesson> lessons;

	public Schedule () {
		lessons = new ArrayList<Lesson>();
	}
	
	/**
	 * Add lesson to the schedule.
	 * @param lesson Lesson to add to the schedule.
	 */
	public void addLesson(Lesson lesson) {
		lessons.add(lesson);
	}

	/**
	 * Remove lesson from the schedule.
	 * @param lesson Lesson to remove from the schedule.
	 */
	public void removeLesson(Lesson lesson) {
		lessons.remove(lesson);
	}
	
	/**
	 * Returns whether a lesson object is scheduled.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the lesson is scheduled.
	 */
	public boolean containsLesson(Lesson lesson) {
		return lessons.contains(lesson);
	}
}
