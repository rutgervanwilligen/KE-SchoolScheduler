package sss.scheduler.objects;

import java.util.ArrayList;

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
	 */
	public void removeClassroom() {
		classroom = null;
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
	 * Allocate a classroom to the lesson object.
	 * @param classroom Classroom to be allocated
	 */
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	/**
	 * Allocate a teacher to the lesson object.
	 * @param teacher Teacher to be allocated
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * Allocate a subject to the lesson object.
	 * @param subject Subject to be allocated
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	 * Set the students to the lesson object. All previously allocated students are removed.
	 * @param classroom Classroom to be allocated
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
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
	
	/**
	 * Get the classroom of the lesson object.
	 * @return Allocated classroom
	 */
	public Classroom getClassroom() {
		return classroom;
	}
	
	/**
	 * Get the subject of the lesson object.
	 * @return Allocated subject
	 */
	public Subject getSubject() {
		return subject;
	}
	
	/**
	 * Get the teacher of the lesson object.
	 * @return Allocated teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	
	/**
	 * Get the ClassInSchool of the lesson object.
	 * @return Allocated ClassInSchool
	 */
	public ClassInSchool getClassInSchool() {
		return classInSchool;
	}
	
	/**
	 * Get the list of students of the lesson object.
	 * @return Allocated students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	/**
	 * Get the weekday of the lesson object.
	 * @return Allocated weekday
	 */
	public Weekday getWeekday() {
		return firstHour.getWeekday();
	}
	
	/**
	 * Get the first hour of the lesson object.
	 * @return Allocated first hour
	 */
	public LessonHour getHour() {
		return firstHour;
	}

	@Override
	public int compareTo(Lesson o) {
		return getHour().compareTo(o.getHour());
	}
}
