package sss.scheduler.objects;

import java.util.ArrayList;

import sss.scheduler.properties.Weekday;

public abstract class Lesson implements Comparable<Lesson> {

	protected Classroom classroom;
	protected Teacher teacher;
	protected ClassInSchool classInSchool;
	protected ArrayList<Student> students;
	protected Subject subject;
	
	protected LessonHour firstHour;
	protected LessonHour secondHour;
	protected boolean doubleHour;
	
	private boolean allowedInGeneralRoom;
	private boolean needsComputerRoom;

	/*
	 * Setters
	 */
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void setHour(LessonHour hour) {
		this.firstHour = hour;
	}

	public void setSecondHour(LessonHour hour) {
		this.secondHour = hour;
	}
	
	/**
	 * Allocate a ClassInSchool to the lesson object. Note that when calling this method,
	 * the student list of the lesson is cleared and instantiated to the students in this ClassInSchool object.
	 * @param classroom Classroom to be allocated
	 */
	public void setClassInSchool(ClassInSchool classInSchool) {
		this.classInSchool = classInSchool;
		
		students.clear();
		for (Student s : classInSchool.getStudents()) {
			students.add(s);
		}	
	}


	/*
	 * Getters
	 */
	public Classroom getClassroom() {
		return classroom;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public ClassInSchool getClassInSchool() {
		return classInSchool;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public Weekday getWeekday() {
		return firstHour.getWeekday();
	}
	
	public LessonHour getHour() {
		return firstHour;
	}
	
	public LessonHour getSecondHour() {
		return secondHour;
	}


	/**
	 * Creates lesson object with weekday and hour, without other contents
	 * @param hour Hour of the lesson
	 */
	public Lesson(LessonHour firstHour, LessonHour secondHour, boolean doubleHour) {
		this.firstHour = firstHour;
		this.secondHour = secondHour;
		this.doubleHour = doubleHour;
		classroom = null;
		teacher = null;
		classInSchool = null;
		students = new ArrayList<Student>();
		subject = null;
	}
	
	/**
	 * Create Lesson object with all fields instantiated. The students included in the class
	 * are the students included in the ClassInSchool object.
	 * @param hour Hour of the lesson
	 * @param subject Subject of the lesson
	 * @param classroom Classroom of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 */
	public Lesson(LessonHour firstHour, LessonHour secondHour, boolean doubleHour, Subject subject, 
			Classroom classroom, Teacher teacher, ClassInSchool classInSchool, boolean allowedInGeneralRoom,
			boolean needsComputerRoom) {
		students = new ArrayList<Student>();
		this.firstHour = firstHour;
		this.secondHour = secondHour;
		this.doubleHour = doubleHour;
		this.subject = subject;
		this.classroom = classroom;
		this.teacher = teacher;
		this.allowedInGeneralRoom = allowedInGeneralRoom;
		this.needsComputerRoom = needsComputerRoom;
		setClassInSchool(classInSchool);
	}

	/**
	 * Create Lesson object without classroom or time slot
	 * @param subject Subject of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 */
	public Lesson(boolean doubleHour, Subject subject, Teacher teacher, ClassInSchool classInSchool,
			boolean allowedInGeneralRoom, boolean needsComputerRoom) {
		students = new ArrayList<Student>();
		this.doubleHour = doubleHour;
		this.subject = subject;
		this.teacher = teacher;
		setClassInSchool(classInSchool);
		classroom = null;
		firstHour = null;
		this.allowedInGeneralRoom = allowedInGeneralRoom;
		this.needsComputerRoom = needsComputerRoom;
	}
	
	/**
	 * Returns whether the lesson needs to be allocated in a computer room.
	 * @return Returns whether the lesson needs to be allocated in a computer room.
	 */
	public boolean needsComputerRoom() {
		return needsComputerRoom;
	}
	
	/**
	 * Returns whether the lesson can be allocated to a general room.
	 * @return Returns whether the lesson can be allocated to a general room.
	 */
	public boolean allowedInGeneralRoom() {
		return allowedInGeneralRoom;
	}
	
	/**
	 * Returns whether the lesson is allocated to a classroom.
	 * @return Returns whether the lesson is allocated to a classroom.
	 */
	public boolean isAllocatedToClassroom() {
		return (classroom != null);
	}
	
	/**
	 * Returns whether the lesson is allocated to a time slot.
	 * @return Returns whether the lesson is allocated to a time slot.
	 */
	public boolean isAllocatedToTimeslot() {
		return (firstHour != null);
	}	
	
	/**
	 * Returns whether the lesson is a double hour or not.
	 * @return Boolean value indicating whether the lesson is a double hour or not.
	 */
	public boolean isDoubleHour() {
		return doubleHour;
	}	

	/**
	 * Removes the allocated time slot for this lesson.
	 */
	public void removeTimeslot() {
		firstHour = null;
		secondHour = null;
	}
	
	/**
	 * Removes the allocated classroom for this lesson.
	 * @return 
	 */
	public Classroom removeClassroom() {
		Classroom result = classroom;
		classroom = null;
		
		return result;
	}
	
	/**
	 * Returns whether the lesson is allocated to a ClassInSchool.
	 * @param classInSchool ClassInSchool object to test for.
	 * @return Returns whether the lesson is allocated to the specified ClassInSchool.
	 */
	public boolean isAllocatedTo(ClassInSchool classInSchool) {
		return classInSchool.getName().equals(this.classInSchool.getName());
	}
	
	/**
	 * Returns whether the lesson is allocated to a classroom.
	 * @param classroom Classroom object to test for.
	 * @return Returns whether the lesson is allocated to the specified Classroom.
	 */
	public boolean isAllocatedTo(Classroom classroom) {
		return classroom.getRoomNumber().equals(this.classroom.getRoomNumber());
	}
	
	/**
	 * Returns whether the lesson is allocated to a teacher.
	 * @param teacher Teacher object to test for.
	 */
	public boolean isAllocatedTo(Teacher teacher) {
		return teacher.equals(this.teacher);
	}
	
	/**
	 * Returns whether the lesson is allocated to a student.
	 * @param student Student object to test for.
	 */
	public boolean isAllocatedTo(Student student) {
		return students.contains(student);
	}
	
	/**
	 * Returns whether the lesson is allocated for a specific weekday / hour combination.
	 * @param firstHour First hour to test for.
	 */
	public boolean isAllocatedTo(LessonHour firstHour) {
		return (firstHour.equals(this.firstHour));
	}
	
	/**
	 * Add a single student to the lesson object.
	 * @param student Student to be added
	 */
	public void addStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		}
	}
	
	/**
	 * Add an ArrayList of Students to the students allocated in this Lesson.
	 * @param list ArrayList<Student> to be added
	 */
	public void addStudents(ArrayList<Student> list) {
		for (Student s : list) {
			addStudent(s);
		}
	}

	@Override
	public int compareTo(Lesson o) {
		return getHour().compareTo(o.getHour());
	}

	/**
	 * Unallocates the given lesson hour and returns the old value.
	 * @param hourNumber int
	 * @return LessonHour
	 */
	public LessonHour unallocateTimeslot(int hourNumber) {
		LessonHour hour;
		switch (hourNumber) {
		case 1:
			hour = firstHour;
			firstHour = null;
			break;
		case 2:
			hour = secondHour;
			secondHour = null;
			break;
		default:
			hour = null;
		}
		return hour;
	}

}
