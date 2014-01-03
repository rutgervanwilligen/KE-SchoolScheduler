package sss.scheduler.objects;
import java.util.ArrayList;

public class Teacher {

	protected String name;
	protected String code;
	protected int weeklyTeachingHours;
	protected String grade;
	protected ArrayList<Subject> subjects;
	protected Availability[] availabilities;
	protected Availability[] scheduledHours;
		
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
	 * Returns the teacher's (unique) code.
	 * @return Teacher's unique code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Returns the availabilities index corresponding to a given lesson hour
	 * @param lessonHour The lesson hour object to check
	 * @return The index of the availabilities array corresponding to the lesson hour
	 */
	private int getLessonHourIndex(LessonHour lessonHour) {
		int nHoursPerDay = availabilities.length / 5;
		int hour = lessonHour.getHour();
		switch (lessonHour.getWeekday()) {
		case MONDAY:
			return (hour - 1);
		case TUESDAY:
			return (nHoursPerDay * 1 + hour - 1);
		case WEDNESDAY:
			return (nHoursPerDay * 2 + hour - 1);
		case THURSDAY:
			return (nHoursPerDay * 3 + hour - 1);
		case FRIDAY:
			return (nHoursPerDay * 4 + hour - 1);
		default:
			System.out.println("Invalid input while getting lesson hour index");
			System.exit(1);
			return -1;
		}
	}
	
	/**
	 * Makes the classroom unavailable for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToUnavailable(LessonHour lessonHour) {
		scheduledHours[getLessonHourIndex(lessonHour)] = Availability.UNAVAILABLE;
	}
	
	/**
	 * Makes the classroom available for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToAvailable(LessonHour lessonHour) {
		scheduledHours[getLessonHourIndex(lessonHour)] = Availability.AVAILABLE;
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
