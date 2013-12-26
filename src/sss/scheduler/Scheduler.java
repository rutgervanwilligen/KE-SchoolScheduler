package sss.scheduler;
import java.util.ArrayList;

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
	protected ArrayList<Teacher> teachers;
	protected ArrayList<ClassInSchool> classes;
	
	public Scheduler() {
		schedule = new Schedule();
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setClasses(ArrayList<ClassInSchool> classes) {
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
		LessonReasoner lessonReasoner = new LessonReasoner();
		lessonReasoner.initiateEngine();
		lessonReasoner.addObjects(teachers);
		lessonReasoner.addObjects(classes);
		lessonReasoner.setLessons(lessonsToSchedule);
		
		Lesson lessonToSchedule = lessonReasoner.getBestLesson();
		
		while (lessonToSchedule != null) {
			System.out.println("Got a lesson with rank: " + lessonToSchedule.getRanking());
//			scheduleLesson(lessonToSchedule);
			lessonToSchedule = lessonReasoner.getBestLesson();
		}
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
