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
	
	public Classroom (String roomNumber, int capacity, Location location, int floor, 
			boolean computerRoom, boolean generalUse, ArrayList<Subject> facilities) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.location = location;
		this.floor = floor;
		this.computerRoom = computerRoom;
		this.generalUse = generalUse;
		this.facilities = facilities;
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
