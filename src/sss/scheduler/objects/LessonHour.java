package sss.scheduler.objects;

public class LessonHour implements Comparable<LessonHour> {
	
	private final int number;
	private final Weekday weekday;
	private final ClockValue startTime;
	private final ClockValue endTime;
	
	public LessonHour(Weekday weekday, int number, int startTimeHour, int startTimeMinutes, int endTimeHour, int endTimeMinutes) {
		this.weekday = weekday;
		this.number = number;
		startTime = new ClockValue(startTimeHour, startTimeMinutes);
		endTime = new ClockValue(endTimeHour, endTimeMinutes);
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
}