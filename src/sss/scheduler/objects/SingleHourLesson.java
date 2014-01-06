package sss.scheduler.objects;

public class SingleHourLesson extends Lesson {

	/**
	 * Creates single hour lesson object without other contents
	 * @param hour Hour of the lesson
	 */
	public SingleHourLesson(LessonHour hour) {
		super(hour, null, false);
	}
	
	/**
	 * Create SingleHourLesson object with all fields instantiated. The students included in the class
	 * are the students included in the ClassInSchool object.
	 * @param hour Hour of the lesson
	 * @param subject Subject of the lesson
	 * @param classroom Classroom of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 * @param allowedInGeneralRoom Boolean to indicate if the lesson can be allocated to a general room
	 * @param needsComputerRoom Boolean to indicate if the lesson needs a computer room
	 */
	public SingleHourLesson(LessonHour hour, Subject subject, Classroom classroom, Teacher teacher, 
			ClassInSchool classInSchool, boolean allowedInGeneralRoom, boolean needsComputerRoom) {
		super(hour, null, false, subject, classroom, teacher, classInSchool, allowedInGeneralRoom, needsComputerRoom);
	}

	/**
	 * Create Lesson object without classroom or time slot
	 * @param subject Subject of the lesson
	 * @param teacher Teacher of the lesson
	 * @param classInSchool Class that gets taught
	 * @param allowedInGeneralRoom Boolean to indicate if the lesson can be allocated to a general room
	 * @param needsComputerRoom Boolean to indicate if the lesson needs a computer room
	 */
	public SingleHourLesson(Subject subject, Teacher teacher, ClassInSchool classInSchool,
			boolean allowedInGeneralRoom, boolean needsComputerRoom) {
		super(false, subject, teacher, classInSchool, allowedInGeneralRoom, needsComputerRoom);
	}
	
	/**
	 * Allocate a lesson to a weekday and hour.
	 * @param weekday The weekday to allocate the lesson to.
	 * @param hour The hour to allocate the lesson to.
	 */
	public void allocateTimeslot(LessonHour hour) {
		firstHour = hour;
	}
	
}
