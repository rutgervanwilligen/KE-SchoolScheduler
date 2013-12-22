package sss.reasoner;

import java.util.ArrayList;
import java.util.Iterator;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Subject;
import jess.Filter;
import jess.JessException;

public class LessonReasoner extends Reasoner {
	
	public static final String SUBJECT_REASONER_FILE = "/home/thomas/School/Knowledge Engeneering/FinalAssignment/program/ke-school-scheduler/rulebase/lesson-selection-model.clp";
	
	protected ArrayList<Lesson> lessons;
	
	public LessonReasoner() {
		this.addRuleFile(SUBJECT_REASONER_FILE);
	}
	
	public void setLessons(ArrayList<Lesson> lessons) throws JessException {
        this.lessons = lessons;
	}
	
	public Lesson getBestLesson() throws JessException {
		Lesson result = null;
		
		engine.resetToMark(marker);
		engine.addAll(lessons);
		engine.run();
		
		Iterator generatedSubjects = engine.getObjects(new Filter.ByClass(Lesson.class));
		// filter best suitable subject
		result = (Lesson) generatedSubjects.next();
		
		lessons.remove(result);
		
		return result;
	}
	
}