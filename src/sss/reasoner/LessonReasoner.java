package sss.reasoner;

import java.util.ArrayList;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Teacher;
import jeops.conflict.PriorityConflictSet;

public class LessonReasoner extends Reasoner {
	
	protected ArrayList<Lesson> lessons;
	protected ArrayList<ClassInSchool> classes;
	protected ArrayList<Teacher> teachers;
	
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

		LessonSelectionKB kb = new LessonSelectionKB(new PriorityConflictSet());
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