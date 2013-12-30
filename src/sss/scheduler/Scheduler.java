package sss.scheduler;
import java.util.ArrayList;
import java.util.TreeMap;

import sss.reasoner.LessonReasoner;
import sss.reasoner.TimeslotReasoner;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Teacher;
import jess.JessException;


public class Scheduler {
	
	protected Schedule schedule;
	protected TreeMap<String, Teacher> teachers;
	protected TreeMap<String, ClassInSchool> classes;
	
	public Scheduler() {
		schedule = new Schedule();
	}

	public void setTeachers(TreeMap<String, Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setClasses(TreeMap<String, ClassInSchool> classes) {
		this.classes = classes;
	}

	public void createSchedule() {
		ClassInSchool classToSchedule;
		ArrayList<Lesson> lessonsToSchedule;
		
		while (! classes.isEmpty()) {
			classToSchedule = classes.remove(0);
			
			lessonsToSchedule = classToSchedule.getLessons();
			try {
				scheduleLessons(lessonsToSchedule);
			} catch (JessException e) {
				System.out.println("JessException: " + e.getMessage());
				System.out.print(e.getStackTrace());
			}
		}
		
	}

	protected void scheduleLessons(ArrayList<Lesson> lessonsToSchedule) throws JessException {
		LessonReasoner reasoner = new LessonReasoner();
		reasoner.addLessons(lessonsToSchedule);
		reasoner.getBestLesson();
	}

	protected void scheduleLesson(Lesson lesson) throws JessException {
		TimeslotReasoner timeslotReasoner = new TimeslotReasoner();
		timeslotReasoner.initiateEngine();
		timeslotReasoner.addObjects(null);
		timeslotReasoner.addLesson(lesson);
		
		timeslotReasoner.run();
		
		Classroom classroom = timeslotReasoner.getBestClassroom();
	}

}
