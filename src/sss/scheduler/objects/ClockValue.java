package sss.scheduler.objects;
public class ClockValue implements Comparable<ClockValue>{
	
	private final int hours;
	private final int minutes;
	
	public ClockValue(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int getHours () {
		return hours;
	}
	
	public int getMinutes () {
		return minutes;
	}
	
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
	
}
