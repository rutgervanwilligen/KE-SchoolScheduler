package sss.scheduler.objects;

public class Availability {

	public final static String AV_YES = "yes";
	public final static String AV_NO = "no";
	public final static String AV_PREF_NO = "rather not";

	protected Weekday weekday;
	protected LessonHour hour;
	protected String availability;
	//TODO Availability als een ENUM? Zo niet: in de constructor een controle-iets? Hoe te koppelen aan AV_YES/AV_NO/AV_PREF_NO?
	
	public Availability(Weekday weekday, LessonHour hour, String availability) {
		this.weekday = weekday;
		this.hour = hour;
		this.availability = availability;
	}
	
	/**
	 * Get the week day of the Availability object.
	 * @return Weekday of the Availability object.
	 */
	public Weekday getWeekday() {
		return weekday;
	}

	/**
	 * Get the hour of the Availability object.
	 * @return Hour of the Availability object.
	 */
	public LessonHour getHour() {
		return hour;
	}
	
	/**
	 * Get the availability value of the Availability object.
	 * @return Availability value of the Availability object.
	 */
	public String getAvailability() {
		return availability;
	}
}
