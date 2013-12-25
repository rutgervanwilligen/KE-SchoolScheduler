package sss.scheduler.objects;
public class ClockValue {
	
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
	
}
