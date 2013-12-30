package sss.scheduler.objects;
import java.util.ArrayList;

public class Teacher {

	public static final String FIRST_GRADE = "first grade teacher";
	public static final String SECOND_GRADE = "second grade teacher";

	protected String name;
	protected String code;
	protected int weeklyTeachingHours;
	protected String grade;
	protected ArrayList<Subject> subjects;
	protected Availability[] availabilities;
	
	// TODO Availabilities
	
	public Teacher (String name, String code, int weeklyTeachingHours, ArrayList<Subject> subjects, 
			String grade, Availability[] availabilities) {
		this.name = name;
		this.code = code;
		this.weeklyTeachingHours = weeklyTeachingHours;
		this.grade = grade;
		this.subjects = subjects;
		this.availabilities = availabilities;
	}

	/**
	 * Returns the teacher's availability on a specific index.
	 * @return Teacher's availability on this index.
	 */
	public Availability getAvailability(int index) {
		return availabilities[index];
	}
	
	/**
	 * Returns the teacher's (unique) code.
	 * @return Teacher's unique code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Returns whether the teacher object is equal to t, by comparing the teacher code.
	 * @param teacher Teacher object to compare.
	 * @return Truth value denoting equality.
	 */
	public boolean equals(Object t) {
		if (t == null) return false;
		if (!(t instanceof Teacher)) return false;
		return ( ((Teacher)t).getCode().equals(this.getCode()));
	}
}
