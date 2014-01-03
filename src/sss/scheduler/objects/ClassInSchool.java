package sss.scheduler.objects;
import java.util.ArrayList;


public abstract class ClassInSchool implements Comparable<ClassInSchool> {
	
	//TODO Student list (eigenlijk niet belangrijk in onderbouw, though)

	protected ArrayList<Student> studentList;
	protected String name;
	protected int year;
	protected char letter;
	protected Level level;
	protected int size;
	protected Teacher mentor;
	protected Availability[] availabilities;
	
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
	 * Initializes the availabilities object of the classroom to 'all available'.
	 * @param nHoursInWeek Amount of lesson hours in a week.
	 */
	private void initializeAvailabilities(int nHoursInWeek) {
		availabilities = new Availability[nHoursInWeek];
		for (int i=0; i<nHoursInWeek; i++) {
			availabilities[i] = Availability.AVAILABLE;
		}
	}
	
	/**
	 * Makes the classroom unavailable for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToUnavailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.UNAVAILABLE;
	}
	
	/**
	 * Makes the classroom available for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToAvailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.AVAILABLE;
	}
	
	/**
	 * Returns whether the classroom is available on a given lesson hour.
	 * @param lessonHour The lesson hour to check.
	 * @return Boolean value indicating whether the classroom is available.
	 */
	public boolean isAvailable(LessonHour lessonHour) {
		return availabilities[getLessonHourIndex(lessonHour)] == Availability.AVAILABLE;
	}
	
	/**
	 * Returns the availabilities index corresponding to a given lesson hour
	 * @param lessonHour The lesson hour object to check
	 * @return The index of the availabilities array corresponding to the lesson hour
	 */
	private int getLessonHourIndex(LessonHour lessonHour) {
		int nHoursPerDay = availabilities.length / 5;
		int hour = lessonHour.getHour();
		switch (lessonHour.getWeekday()) {
		case MONDAY:
			return (hour - 1);
		case TUESDAY:
			return (nHoursPerDay * 1 + hour - 1);
		case WEDNESDAY:
			return (nHoursPerDay * 2 + hour - 1);
		case THURSDAY:
			return (nHoursPerDay * 3 + hour - 1);
		case FRIDAY:
			return (nHoursPerDay * 4 + hour - 1);
		default:
			System.out.println("Invalid input while getting lesson hour index");
			System.exit(1);
			return -1;
		}
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
	 * Returns the class's year.
	 */	
	public int getYear() {
		return year;
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
//		Lesson a = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
//		a.setSubject(new Subject("handenarbeid", "HA", false));
//		result.add(a);
//		Lesson b = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
//		b.setSubject(new Subject("lichamelijke opvoeding", "LO", false));
//		result.add(b);
//		Lesson c = new Lesson(Weekday.MONDAY, new LessonHour(year, year, year, year, year));
//		c.setSubject(new Subject("nederlands", "NL", false));
//		result.add(c);
		
		return result;
	}
	
	@Override
	public int compareTo(ClassInSchool c) {
		return name.compareTo(c.getName());
	}
	
	public boolean equals(ClassInSchool c) {
		return compareTo(c) == 0;
	}
	
}
