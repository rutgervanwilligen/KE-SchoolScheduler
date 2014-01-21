package sss.scheduler.objects;

import sss.scheduler.properties.ClockValue;
import sss.scheduler.properties.Weekday;

public class LessonHour implements Comparable<LessonHour> {
	
	private final int number;
	private final Weekday weekday;
	private final ClockValue startTime;
	private final ClockValue endTime;
	private LessonHour nextHour;
	private boolean preferredForDoubleHour;

	/*
	 * Getters
	 */
	public LessonHour getNextHour() {
		return nextHour;
	}
	
	public int getHour() {
		return number;
	}
	
	public Weekday getWeekday() {
		return weekday;
	}
	
	public ClockValue getStartTime () {
		return startTime;
	}
	
	public ClockValue getEndTime () {
		return endTime;
	}
	
	/**
	 * Constructor
	 * 
	 * @param weekday
	 * @param number
	 * @param startTimeHour
	 * @param startTimeMinutes
	 * @param endTimeHour
	 * @param endTimeMinutes
	 */
	public LessonHour(Weekday weekday, int number, int startTimeHour, int startTimeMinutes, 
			int endTimeHour, int endTimeMinutes) {
		this.weekday = weekday;
		this.number = number;
		startTime = new ClockValue(startTimeHour, startTimeMinutes);
		endTime = new ClockValue(endTimeHour, endTimeMinutes);
		nextHour = null;
		preferredForDoubleHour = false;
	}
	
	/**
	 * Checks if there is a lesson hour directly after this lesson hour.
	 * @return boolean
	 */
	public boolean hasNextHour() {
		return (nextHour != null);
	}
	
	/**
	 * Set the next lesson hour for this lesson hour.
	 * @param nextHour
	 */
	public void addNextHour(LessonHour nextHour) {
		this.nextHour = nextHour;
	}

	@Override
	public int compareTo(LessonHour other) {
		Weekday otherWeekday = other.getWeekday();
		if (!(weekday == otherWeekday)) {
			return weekday.compareTo(otherWeekday);
		} else {
			int otherNumber = other.getHour();
			if (number < otherNumber) {
				return -1;
			} else if (number > otherNumber) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public void setPreferredForDoubleHour(boolean b) {
		this.preferredForDoubleHour = b;		
	}
	
	
	public boolean preferredForDoubleHour() {
		return preferredForDoubleHour;
	}
}