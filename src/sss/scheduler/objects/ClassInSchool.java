package sss.scheduler.objects;
import java.util.ArrayList;

import sss.scheduler.Resource;
import sss.scheduler.properties.Availability;
import sss.scheduler.properties.Level;


public abstract class ClassInSchool extends Resource implements Comparable<ClassInSchool> {
	
	//TODO Student list (eigenlijk niet belangrijk in onderbouw, though)

	protected ArrayList<Student> studentList;
	protected String name;
	protected int year;
	protected char letter;
	protected Level level;
	protected int size;
	protected Teacher mentor;


	/*
	 * Getters
	 */
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getSize() {
		return size;
	}	
	
	public Level getLevel() {
		return level;
	}
	
	public ArrayList<Student> getStudents () {
		return studentList;
	}


	/**
	 * Create new class in school.
	 * @param name Class's name
	 * @param level Class's education level
	 * @param year Class's year
	 * @param letter Class's letter
	 * @param mentor Class's mentor
	 * @param size Class's size
	 * @param nWeeklyHours Amount of lesson hours weekly
	 */
	public ClassInSchool (String name, Level level, int year, char letter, Teacher mentor, int size, int nWeeklyHours) {
		studentList = new ArrayList<Student>();
		this.name = name;
		this.year = year;
		this.letter = letter;
		this.level = level;
		this.size = size;
		this.mentor = mentor;
		initializeAvailabilities(nWeeklyHours);
	}
	
	/**
	 * Add student to the class.
	 * @param student Student Student to add
	 */	
	public boolean addStudent(Student student) {
		return studentList.add(student);
	}
	
	@Override
	public int compareTo(ClassInSchool c) {
		return name.compareTo(c.getName());
	}
	
	public boolean equals(ClassInSchool c) {
		return compareTo(c) == 0;
	}
	
}
