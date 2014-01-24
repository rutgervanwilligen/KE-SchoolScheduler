package sss.scheduler.properties;

import java.util.ArrayList;
import java.util.Collections;

import sss.scheduler.objects.LessonHour;

public class ClockValue implements Comparable<ClockValue>{
	
	protected final int hours;
	protected final int minutes;
	

	/*
	 * Getters
	 */
	public int getHours () {
		return hours;
	}
	
	public int getMinutes () {
		return minutes;
	}
	
	/**
	 * Constructor
	 * @param hours
	 * @param minutes
	 */
	public ClockValue(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * Get the time difference in minutes between this clock value and cv.
	 * @param cv ClockValue
	 * @return int Number of minutes
	 */
	public int getTimeDiffMinutes(ClockValue cv) {
		int thisValueInMinutes = hours * 60 + minutes;
		int thatValueInMinutes = cv.getHours() * 60 + cv.getMinutes();
		
		return Math.abs(thisValueInMinutes - thatValueInMinutes);
	}

	@Override
	public int compareTo(ClockValue o) {
		int otherHours = o.getHours();
		if (hours < otherHours) {
			return -1;
		} else if (hours > otherHours) {
			return 1;
		} else {
			int otherMinutes = o.getMinutes();
			if (minutes < otherMinutes) {
				return -1;
			} else if (minutes > otherMinutes) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public boolean equals(ClockValue cv) {
		return (compareTo(cv) == 0);
	}

	public static ArrayList<ClockValue> getUniqueStartingClockValues(ArrayList<LessonHour> hours) {
		ArrayList<ClockValue> clockValues = new ArrayList<ClockValue>();
		
		for (LessonHour lessonHour : hours) {
			if (lessonHour.getWeekday() == Weekday.MONDAY) {
				clockValues.add(lessonHour.getStartTime());
			}
		}
		Collections.sort(clockValues);
		
		return clockValues;
	}
}
