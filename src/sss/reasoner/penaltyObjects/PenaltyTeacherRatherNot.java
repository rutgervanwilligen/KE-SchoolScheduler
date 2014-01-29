package sss.reasoner.penaltyObjects;

import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Teacher;

public class PenaltyTeacherRatherNot extends Penalty {
	
	public Teacher teacher;
	public LessonHour lessonHour;
	
	public PenaltyTeacherRatherNot(Teacher teacher, LessonHour lessonHour) {
		this.teacher = teacher;
		this.lessonHour = lessonHour;
	}

}
