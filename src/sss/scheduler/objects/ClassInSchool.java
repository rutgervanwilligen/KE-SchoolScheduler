package sss.scheduler.objects;
import java.util.ArrayList;


public abstract class ClassInSchool {

	protected ArrayList<Student> studentList;
	protected String name;
	protected int year;
	protected char letter;
	protected Level level;
	protected int size;
	protected Teacher mentor;
	
	/**
	 * Create new class in school.
	 * @param year int Class's year
	 * @param letter char Class's letter
	 * @param level Level Class's education level
	 */
	public ClassInSchool (String name, Level level, int year, char letter, Teacher mentor, int size) {
		this.name = name;
		this.year = year;
		this.letter = letter;
		this.level = level;
		this.size = size;
		this.mentor = mentor;
	}
	
	/**
	 * Add student to the class.
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
		ArrayList<Lesson> result = new ArrayList<Lesson>();

		// FIXME: temp invulling van lessons, moet nog aangepast worden.
		Lesson a = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
		a.setSubject(new Subject("handenarbeid", "HA", false));
		result.add(a);
		Lesson b = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
		b.setSubject(new Subject("lichamelijke opvoeding", "LO", false));
		result.add(b);
		Lesson c = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
		c.setSubject(new Subject("nederlands", "NL", false));
		result.add(c);
		
		return result;
	}
	
}
