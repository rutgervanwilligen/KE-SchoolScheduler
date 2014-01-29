package sss.reasoner.penaltyObjects;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.LessonHour;

public class PenaltyClassBetweenHours extends Penalty {

	public ClassInSchool classInSchool;
	public LessonHour lessonHour;
	
	public PenaltyClassBetweenHours(ClassInSchool classInSchool, LessonHour lessonHour) {
		this.classInSchool = classInSchool;
		this.lessonHour = lessonHour;
	}
	
}
