package sss.scheduler.properties;
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
}
