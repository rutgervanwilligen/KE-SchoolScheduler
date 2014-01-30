package sss.reasoner.penaltyObjects;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Teacher;

public class PenaltyTeacherWalking extends Penalty {
	
	public Teacher teacher;
	public Lesson lesson1;
	public Lesson lesson2;
	
	public PenaltyTeacherWalking(Teacher teacher, Lesson lesson1, Lesson lesson2) {
		this.teacher = teacher;
		this.lesson1 = lesson1;
		this.lesson2 = lesson2;
	}

}
