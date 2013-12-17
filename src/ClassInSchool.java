import java.util.ArrayList;


public abstract class ClassInSchool {

	protected ArrayList<Student> studentList;
	protected String name;
	protected int year;
	protected char letter;
	protected Level level;
	
	public ClassInSchool (int year, char letter, Level level) {
		this.year = year;
		this.letter = letter;
		this.level = level;
		name = level + Integer.toString(year) + letter;
	}
	
	public boolean addStudent(Student student) {
		return studentList.add(student);
	}

	public String getName() {
		return name;
	}
	
	public Level getLevel() {
		return level;
	}
	
}
