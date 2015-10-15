package sss.scheduler.objects;

public class DoubleHourLesson extends Lesson {

	/**
	 * Creates double hour lesson object without other contents
	 * @param firstHour First hour of the lesson
	 * @param secondHour Second hour of the lesson
	 */
	public DoubleHourLesson(LessonHour firstHour, LessonHour secondHour) {
		super(firstHour, secondHour, true);
	}
	
	/**
	 * Create SingleHourLesson object with all fields instantiated. The students included in the class
	 * are the students included in the ClassInSchool object.
	 * @param firstHour First hour of the lesson
	 * @param secondHour Second hour of the lesson
	 * @param subject Subject of the lesson
	 * @param classroom Classroom of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 * @param allowedInGeneralRoom Boolean to indicate if the lesson can be allocated to a general room
	 * @param needsComputerRoom Boolean to indicate if the lesson needs a computer room
	 */
	public DoubleHourLesson(LessonHour firstHour, LessonHour secondHour, Subject subject, 
			Classroom classroom, Teacher teacher, ClassInSchool classInSchool,
			boolean allowedInGeneralRoom, boolean needsComputerRoom) {
		super(firstHour, secondHour, true, subject, classroom, teacher, classInSchool,
				allowedInGeneralRoom, needsComputerRoom);
	}

	/**
	 * Create Lesson object without classroom or time slot
	 * @param subject Subject of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 * @param allowedInGeneralRoom Boolean to indicate if the lesson can be allocated to a general room
	 * @param needsComputerRoom Boolean to indicate if the lesson needs a computer room
	 */
	public DoubleHourLesson(Subject subject, Teacher teacher, ClassInSchool classInSchool,
			boolean allowedInGeneralRoom, boolean needsComputerRoom) {
		super(true, subject, teacher, classInSchool, allowedInGeneralRoom, needsComputerRoom);
	}
	
	/**
	 * Allocate a lesson to two hours.
	 * @param firstHour The first hour to allocate the lesson to.
	 * @param secondHour The second hour to allocate the lesson to.
	 */
	public void allocateTimeslot(LessonHour firstHour, LessonHour secondHour) {
		this.firstHour = firstHour;
		this.secondHour = secondHour;
	}
	
}
