package sss.scheduler.objects;

import java.util.ArrayList;

public class Lesson {

	private Classroom classroom;
	private Teacher teacher;
	private ClassInSchool classInSchool;
	private ArrayList<Student> students;
	private Subject subject;
	
	private Weekday weekday;
	private LessonHour hour;
	
	protected int ranking;
	
	/**
	 * Creates lesson object with weekday and hour, without other contents
	 * @param weekday Weekday of the lesson
	 * @param hour Hour of the lesson
	 */
	public Lesson(Weekday weekday, LessonHour hour) {
		this.weekday = weekday;
		this.hour = hour;
		classroom = null;
		teacher = null;
		classInSchool = null;
		students = new ArrayList<Student>();
		subject = null;
		ranking = 0;
	}
	
	/**
	 * Create Lesson object with all fields instantiated. The students included in the class
	 * are the students included in the ClassInSchool object.
	 * @param weekday Weekday of the lesson
	 * @param hour Hour of the lesson
	 * @param subject Subject of the lesson
	 * @param classroom Classroom of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 */
	public Lesson(Weekday weekday, LessonHour hour, Subject subject, Classroom classroom, Teacher teacher, ClassInSchool classInSchool) {
		this.weekday = weekday;
		this.hour = hour;
		this.subject = subject;
		this.classroom = classroom;
		this.teacher = teacher;
		setClassInSchool(classInSchool);
	}
	
	public Lesson(Subject subject, Classroom classroom, Teacher teacher, ClassInSchool classInSchool) {
		this.subject = subject;
		this.teacher = teacher;
		setClassInSchool(classInSchool);
		classroom = null;
		weekday = null;
		hour = null;
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
		return (weekday != null && hour != null);
	}	
	
	/**
	 * Allocate a lesson to a weekday and hour.
	 * @param weekday The weekday to allocate the lesson to.
	 * @param hour The hour to allocate the lesson to.
	 */
	public void allocateTimeslot(Weekday weekday, LessonHour hour) {
		this.weekday = weekday;
		this.hour = hour;
	}

	/**
	 * Removes the allocated time slot for this lesson.
	 */
	public void removeTimeslot() {
		weekday = null;
		hour = null;
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
	 * @param weekday Weekday to test for.
	 * @param hour Hour to test for.
	 */
	public boolean isAllocatedTo(Weekday weekday, LessonHour hour) {
		return (weekday.equals(this.weekday) && hour.equals(this.hour));
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
		return weekday;
	}
	
	/**
	 * Get the classroom of the lesson object.
	 * @return Allocated hour
	 */
	public LessonHour getHour() {
		return hour;
	}

	/**
	 * Get the rank generated for selecting the best classroom. 
	 * @return
	 */
	public int getRanking() {
		return this.ranking;
	}
	
	/**
	 * Set the rank generated for selecting the best classroom. 
	 * @return
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
}
