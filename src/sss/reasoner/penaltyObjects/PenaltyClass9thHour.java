package sss.reasoner.penaltyObjects;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.LessonHour;

public class PenaltyClass9thHour extends Penalty {

	public ClassInSchool classInSchool;
	public LessonHour lessonHour;
	
	public PenaltyClass9thHour(ClassInSchool classInSchool, LessonHour lessonHour) {
		this.classInSchool = classInSchool;
		this.lessonHour = lessonHour;
	}
	
}
