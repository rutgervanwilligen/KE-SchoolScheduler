package sss.scheduler.objects;
import java.util.ArrayList;

import sss.scheduler.Resource;
import sss.scheduler.properties.Availability;

public class Teacher extends Resource {

	protected String name;
	protected String code;
	protected int weeklyTeachingHours;
	protected String grade;
	protected ArrayList<Subject> subjects;
	protected Availability[] scheduledHours;

	/*
	 * Getters 
	 */
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
	/**
	 * Constructor
	 * @param name
	 * @param code
	 * @param weeklyTeachingHours
	 * @param subjects
	 * @param grade
	 * @param availabilities
	 */
	public Teacher (String name, String code, int weeklyTeachingHours, ArrayList<Subject> subjects, 
			String grade, Availability[] availabilities) {
		this.name = name;
		this.code = code;
		this.weeklyTeachingHours = weeklyTeachingHours;
		this.grade = grade;
		this.subjects = subjects;
		this.availabilities = availabilities;
		initializeScheduledHours(availabilities.length);
	}
	
	/**
	 * Initializes the availabilities object of the classroom to 'all available'.
	 * @param nHoursInWeek Amount of lesson hours in a week.
	 */
	private void initializeScheduledHours(int nHoursInWeek) {
		scheduledHours = new Availability[nHoursInWeek];
		for (int i=0; i<nHoursInWeek; i++) {
			scheduledHours[i] = Availability.AVAILABLE;
		}
	}
	
	/**
	 * Checks whether the teacher is suited for a lesson
	 * @param lesson The lesson to check for
	 */
	public boolean isSuitedFor(Lesson lesson) {
		if (lesson.getSubject().getCode().equals("SL")) {
			return true;
		}
		return subjects.contains(lesson.getSubject());
	}
	
	/**
	 * Returns the teacher's indicated availability on a given LessonHour.
	 * @param lessonHour The lesson hour to check the teacher's availability of.
	 * @return Teacher's availability on the given LessonHour.
	 */
	public Availability getAvailability(LessonHour lessonHour) {
		return availabilities[getLessonHourIndex(lessonHour)];
	}
	
	/**
	 * Returns whether the teacher is scheduled on a given lesson hour.
	 * @param lessonHour The lesson hour to check.
	 * @return Boolean value indicating whether the classroom is available.
	 */
	public boolean isScheduled(LessonHour lessonHour, Lesson lesson) {
		if (lesson instanceof DoubleHourLesson) {
			return lessonHour.hasNextHour() &&
					scheduledHours[getLessonHourIndex(lessonHour)] != Availability.AVAILABLE &&
					scheduledHours[getLessonHourIndex(lessonHour.getNextHour())] != Availability.AVAILABLE;
		}
		return scheduledHours[getLessonHourIndex(lessonHour)] != Availability.AVAILABLE;
	}
	
	/**
	 * Returns whether the teacher has been scheduled for a given lesson hour.
	 * @return Availability object indicating whether the teacher has been scheduled for this hour.
	 */
	public Availability getScheduledValue(LessonHour lessonHour) {
		return scheduledHours[getLessonHourIndex(lessonHour)];
	}
	
	/**
	 * Returns whether the teacher object is equal to t, by comparing the teacher code.
	 * @param teacher Teacher object to compare.
	 * @return Truth value denoting equality.
	 */
	public boolean equals(Object t) {
		if (t == null) return false;
		if (!(t instanceof Teacher)) return false;
		return ( ((Teacher)t).getCode().equals(this.getCode()));
	}
}
