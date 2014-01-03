package sss.scheduler.objects;

public class HigherClass extends ClassInSchool {

	/**
	 * Create new higher class in school.
	 * @param name Class's name
	 * @param level Class's education level
	 * @param year Class's year
	 * @param letter Class's letter
	 * @param mentor Class's mentor
	 * @param size Class's size
	 * @param nWeeklyHours Amount of lesson hours weekly
	 */
	public HigherClass(String name, Level level, int year, char letter, Teacher mentor, int size, int nWeeklyHours) {
		super(name, level, year, letter, mentor, size, nWeeklyHours);
	}
}
