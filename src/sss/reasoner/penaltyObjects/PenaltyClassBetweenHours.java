package sss.reasoner.penaltyObjects;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.LessonHour;

public class PenaltyClassBetweenHours extends Penalty {

	public ClassInSchool classInSchool;
	
	public PenaltyClassBetweenHours(ClassInSchool classInSchool) {
		this.classInSchool = classInSchool;
	}
	
}
