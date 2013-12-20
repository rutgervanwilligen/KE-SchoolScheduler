import java.util.ArrayList;


public abstract class ClassInSchool {

	protected ArrayList<Student> studentList;
	protected String name;
	protected int year;
	protected char letter;
	protected Level level;
	
	/**
	 * Create new class in school.
	 * 
	 * @param year int Class's year
	 * @param letter char Class's letter
	 * @param level Level Class's education level
	 */
	public ClassInSchool (int year, char letter, Level level) {
		this.year = year;
		this.letter = letter;
		this.level = level;
		name = level + Integer.toString(year) + letter;
	}
	
	/**
	 * Add student to the class.
	 * 
	 * @param student Student Student to add
	 */	
	public boolean addStudent(Student student) {
		return studentList.add(student);
	}

	/**
	 * Returns the class's name.
	 */	
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the class's education level.
	 */	
	public Level getLevel() {
		return level;
	}
	
	public ArrayList<Student> getStudents () {
		return studentList;
	}
	
	public ArrayList<Lesson> getLessons() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
