package sss.scheduler.objects;

import java.util.ArrayList;

public class Classroom {

	final static String LOCATION_MAIN = "HG";
	final static String LOCATION_DEP_1 = "DEP1";
	// TODO Hoe ga je met deze strings om?
	
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
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public ArrayList<Subject> getFacilities() {
		return facilities;
	}
	
	public boolean isSuitedForGeneralUse() {
		return generalUse;
	}
	
	public boolean isComputerRoom() {
		return computerRoom;
	}
}
