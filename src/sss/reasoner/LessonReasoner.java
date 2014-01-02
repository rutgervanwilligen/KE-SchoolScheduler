package sss.reasoner;

import java.util.ArrayList;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Teacher;
import jeops.conflict.PriorityConflictSet;

public class LessonReasoner extends Reasoner {
	
	public static final String SUBJECT_REASONER_FILE = "/home/thomas/School/KE/FinalAssignment/program/ke-school-scheduler/rulebase/lesson-selection-model.clp";

	protected ArrayList<Lesson> lessons;
	protected ArrayList<ClassInSchool> classes;
	protected ArrayList<Teacher> teachers;
	
	public LessonReasoner() {
		this.addRuleFile(SUBJECT_REASONER_FILE);
	}
	
	public void addClasses(ArrayList<ClassInSchool> classes) {
		this.classes = classes;
	}
	
	public void addTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public void addLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
	}
	
	public Lesson getBestLesson() {

	    BaseLesson kb = new BaseLesson(new PriorityConflictSet());
	    for (Lesson lesson : lessons) {
			kb.tell(lesson);
		}
	    kb.run();
	    
	    for (Lesson lesson : lessons) {
			System.out.println(lesson.getRanking());
		}
		
		return null;
	}
	
}