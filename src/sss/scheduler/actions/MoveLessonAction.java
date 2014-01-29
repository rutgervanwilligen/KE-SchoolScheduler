package sss.scheduler.actions;

import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.LessonHour;

public class MoveLessonAction extends ScheduleAction {
	
	public Lesson lesson;
	public LessonHour lessonHour;
	public Classroom classroom;
	
	public MoveLessonAction(Lesson lesson, LessonHour newLessonHour, Classroom newClassroom) {
		this.lesson = lesson;
		this.lessonHour = newLessonHour;
		this.classroom = newClassroom;
	}

}
