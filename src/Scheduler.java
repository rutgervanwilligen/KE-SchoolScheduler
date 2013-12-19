import java.util.ArrayList;

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
				System.out.println(e.getMessage());
			}
		}
		
	}

	protected void scheduleLessons(ArrayList<Lesson> lessonsToSchedule) throws JessException {
		LessonReasoner lessonReasoner = new LessonReasoner();
		lessonReasoner.addObjects(teachers);
		lessonReasoner.addObjects(classes);
		lessonReasoner.setLessons(lessonsToSchedule);
		
		Lesson lessonToSchedule = lessonReasoner.getMostSuitableLesson();
		while (lessonToSchedule != null) {
			scheduleLesson(lessonToSchedule);
			lessonToSchedule = lessonReasoner.getMostSuitableLesson();
		}
	}

	protected void scheduleLesson(Lesson lesson) throws JessException {
		TimeslotReasoner timeslotReasoner = new TimeslotReasoner();
		timeslotReasoner.addObjects(null);
		timeslotReasoner.addLesson(lesson);
		
		timeslotReasoner.run();
		
		Classroom classroom = timeslotReasoner.getBestClassroom();
	}

}
