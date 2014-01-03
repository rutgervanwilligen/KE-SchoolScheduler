package sss.scheduler.objects;

import java.util.ArrayList;

public class Classroom {

	protected String roomNumber;
	protected int capacity;
	protected Location location;
	protected int floor;
	protected ArrayList<Subject> facilities;
	protected boolean computerRoom;
	protected boolean generalUse;
	protected Availability[] availabilities;
	
	/**
	 * Constructor in which all information of the classroom is stored.
	 * @param roomNumber Classroom's room number
	 * @param capacity Classroom's capacity
	 * @param location Classroom's location
	 * @param floor Classroom's floor
	 * @param computerRoom Boolean indicating whether the classroom is a computer room or not
	 * @param generalUse Boolean indicating whether the classroom is suited for general use or not
	 * @param facilities ArrayList of subjects indicating specific subjects the classroom is suited for
	 * @param nHoursInWeek Amount of lesson hours in a week
	 */
	public Classroom (String roomNumber, int capacity, Location location, int floor, 
			boolean computerRoom, boolean generalUse, ArrayList<Subject> facilities, int nHoursInWeek) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.location = location;
		this.floor = floor;
		this.computerRoom = computerRoom;
		this.generalUse = generalUse;
		this.facilities = facilities;
		initializeAvailabilities(nHoursInWeek);
	}
	
	/**
	 * Initializes the availabilities object of the classroom to 'all available'.
	 * @param nHoursInWeek Amount of lesson hours in a week.
	 */
	private void initializeAvailabilities(int nHoursInWeek) {
		availabilities = new Availability[nHoursInWeek];
		for (int i=0; i<nHoursInWeek; i++) {
			availabilities[i] = Availability.AVAILABLE;
		}
	}
	
	/**
	 * Makes the classroom unavailable for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToUnavailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.UNAVAILABLE;
	}
	
	/**
	 * Makes the classroom available for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToAvailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.AVAILABLE;
	}
	
	/**
	 * Returns whether the classroom is available on a given lesson hour.
	 * @param lessonHour The lesson hour to check.
	 * @return Boolean value indicating whether the classroom is available.
	 */
	public boolean isAvailable(LessonHour lessonHour) {
		return availabilities[getLessonHourIndex(lessonHour)] == Availability.AVAILABLE;
	}
	
	/**
	 * Returns the availabilities index corresponding to a given lesson hour
	 * @param lessonHour The lesson hour object to check
	 * @return The index of the availabilities array corresponding to the lesson hour
	 */
	private int getLessonHourIndex(LessonHour lessonHour) {
		int nHoursPerDay = availabilities.length / 5;
		int hour = lessonHour.getHour();
		switch (lessonHour.getWeekday()) {
		case MONDAY:
			return (hour - 1);
		case TUESDAY:
			return (nHoursPerDay * 1 + hour - 1);
		case WEDNESDAY:
			return (nHoursPerDay * 2 + hour - 1);
		case THURSDAY:
			return (nHoursPerDay * 3 + hour - 1);
		case FRIDAY:
			return (nHoursPerDay * 4 + hour - 1);
		default:
			System.out.println("Invalid input while getting lesson hour index");
			System.exit(1);
			return -1;
		}
	}
	
	/**
	 * Returns the room number.
	 * @return String containing the room number.
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	
	/**
	 * Returns the room's capacity.
	 * @return Room's capacity.
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Returns the room's location.
	 * @return Location object of the room's location.
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Returns the room's floor.
	 * @return Integer value denoting the room's floor.
	 */
	public int getFloor() {
		return floor;
	}
	
	/**
	 * Returns an ArrayList of subjects denoting the specific facilities of the room.
	 * @return ArrayList of subjects this room is suited for.
	 */
	public ArrayList<Subject> getFacilities() {
		return facilities;
	}
	
	/**
	 * Returns whether this room is suited for a specified subject.
	 * @param subject Subject to check.
	 * @return Boolean value indicating whether the classroom is suited for the subject.
	 */
	public boolean isSuitedFor(Subject subject) {
		return facilities.contains(subject);
	}
	
	/**
	 * Returns whether this classroom is suited for general use.
	 * @return Boolean value indicating general usability.
	 */
	public boolean isSuitedForGeneralUse() {
		return generalUse;
	}

	/**
	 * Returns whether this classroom is a computer room.
	 * @return Boolean value indicating this room is a computer room or not.
	 */
	public boolean isComputerRoom() {
		return computerRoom;
	}
}
