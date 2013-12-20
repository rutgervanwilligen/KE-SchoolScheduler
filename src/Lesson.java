import java.util.ArrayList;

public class Lesson {

	private Classroom classroom;
	private Teacher teacher;
	private ClassInSchool classInSchool;
	private ArrayList<Student> students;
	
	private Weekday weekday;
	private Hour hour;
	
	/**
	 * Default constructor. Create new Lesson object without contents
	 */
	public Lesson () {

	}
	
	/**
	 * Create Lesson object with all fields instantiated. The students included in the class
	 * are the students included in the ClassInSchool object.
	 * @param weekday Weekday of the lesson
	 * @param hour Hour of the lesson
	 * @param classroom Classroom of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 */
	public Lesson(Weekday weekday, Hour hour, Classroom classroom, Teacher teacher, ClassInSchool classInSchool) {
		this.weekday = weekday;
		this.hour = hour;
		this.classroom = classroom;
		this.teacher = teacher;
		this.classInSchool = classInSchool;
	}
	
	/**
	 * Allocate a classroom to the lesson object.
	 * @param classroom Classroom to be allocated
	 */
	public void setClassRoom(Classroom classroom) {
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
	public Hour getHour() {
		return hour;
	}
}
