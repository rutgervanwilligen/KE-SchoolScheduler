package sss.scheduler.objects;

public class LessonHour {
	
	private final int number;
	private final ClockValue startTime;
	private final ClockValue endTime;
	
	public LessonHour(int number, int startTimeHour, int startTimeMinutes, int endTimeHour, int endTimeMinutes) {
		this.number = number;
		startTime = new ClockValue(startTimeHour, startTimeMinutes);
		endTime = new ClockValue(endTimeHour, endTimeMinutes);
	}
	
	public int getHour() {
		return number;
	}
	
	public ClockValue getStartTime () {
		return startTime;
	}
	
	public ClockValue getEndTime () {
		return endTime;
	}
}