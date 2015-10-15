package sss.scheduler.objects;

import java.util.ArrayList;

import sss.scheduler.Resource;
import sss.scheduler.properties.Location;

public class Classroom extends Resource {

	protected String roomNumber;
	protected int capacity;
	protected Location location;
	protected int floor;
	protected ArrayList<Subject> facilities;
	protected boolean computerRoom;
	protected boolean generalUse;
	

	/*
	 * Getters
	 */
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
	 * Returns whether this room is suited for a specified subject.
	 * @param subject Subject to check.
	 * @return Boolean value indicating whether the classroom is suited for the subject.
	 */
	public boolean isSuitedFor(Subject subject) {
		return (facilities.contains(subject));
	}
	
	/**
	 * Returns whether this room is suited for a specified lesson.
	 * @param lesson Lesson to check.
	 * @return Boolean value indicating whether the classroom is suited for the subject.
	 */
	public boolean isSuitedFor(Lesson lesson) {
		if (capacity < lesson.getClassInSchool().getSize()) return false;
		if (lesson.needsComputerRoom() && computerRoom) {
			return true;
		}
		if (lesson.allowedInGeneralRoom() && generalUse) {
			return true;
		}
		return (facilities.contains(lesson.getSubject()));
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
