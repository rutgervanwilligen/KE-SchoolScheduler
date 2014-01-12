package sss.scheduler.objects;

import sss.scheduler.properties.Level;

public class LowerClass extends ClassInSchool {

	/**
	 * Create new lower class in school.
	 * @param name Class's name
	 * @param level Class's education level
	 * @param year Class's year
	 * @param letter Class's letter
	 * @param mentor Class's mentor
	 * @param size Class's size
	 * @param nWeeklyHours Amount of lesson hours weekly
	 */
	public LowerClass(String name, Level level, int year, char letter, Teacher mentor, int size, int nWeeklyHours) {
		super(name, level, year, letter, mentor, size, nWeeklyHours);
	}
	
}
