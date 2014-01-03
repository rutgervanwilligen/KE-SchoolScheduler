package sss.scheduler;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import jeops.conflict.PriorityConflictSet;
import sss.reasoner.ClassroomTimeslotAllocationKB;
import sss.reasoner.LessonSelectionKB;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class Scheduler {
	
	protected Schedule schedule;
	protected ArrayList<LessonHour> hours;
	protected TreeMap<String, Subject> subjects;
	protected TreeMap<String, Classroom> classrooms;
	protected TreeMap<String, Teacher> teachers;
	protected TreeMap<String, ClassInSchool> classes;
	protected SubjectClassAllocation subjectsClasses;
	protected TeacherClassAllocation teachersClasses;
	
	public Scheduler(ArrayList<LessonHour> hours, TreeMap<String, Subject> subjects, 
			TreeMap<String, Teacher> teachers, TreeMap<String, Classroom> classrooms, 
			TreeMap<String, ClassInSchool> classes, SubjectClassAllocation subjectsClasses, 
			TeacherClassAllocation teachersClasses) {
		schedule = new Schedule();
		this.hours = hours;
		this.subjects = subjects;
		this.teachers = teachers;
		this.classrooms = classrooms;
		this.classes = classes;
		this.subjectsClasses = subjectsClasses;
		this.teachersClasses = teachersClasses;
	}
	
	/**
	 * Main scheduling loop as found in the knowledge model.
	 */
	public void createSchedule() {
		addAllLessonsToSchedule();
		
		while (schedule.containsUnallocatedLessons()) {
			selectLessonToSchedule();
			allocateLessonToClassroomAndTimeslot();
		}
		
		
		
	}
	
	
	public void selectLessonToSchedule() {
		LessonSelectionKB kb = new LessonSelectionKB(new PriorityConflictSet());
		kb.tell(schedule);
		
		// TODO is deze stap nodig? Feitelijk zitten al die lessons al in het schedule
		// maar ik denk dat de KB er anders niet mee om kan gaan
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			kb.tell(lesson);
		}
		
		kb.run();
		// Lesson to schedule is now stored in schedule's "conflict set"
	}
	
	public void allocateLessonToClassroomAndTimeslot() {
		ClassroomTimeslotAllocationKB kb = new ClassroomTimeslotAllocationKB();
		
		// Add schedule to KB
		kb.tell(schedule);
		
		// Add classrooms to KB
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			kb.tell(entry.getValue());
		}
		
		// Add hours to KB
		for (LessonHour hour : hours) {
			kb.tell(hour);
		}
		
		// Add teachers to KB
		for (Entry<String, Teacher> entry : teachers.entrySet()) {
			kb.tell(entry.getValue());
		}
		
		// Add lessons from schedule's conflict set to KB
		for (Lesson lesson : schedule.getSchedulingSet()) {
			kb.tell(lesson);
		}
		
		kb.run();
		// Lesson from schedule's "conflict set" is now allocated to classroom and time slot
	}	
	
	public void addAllLessonsToSchedule() {
		
		for (Entry<String, Subject> subjectEntry : subjects.entrySet()) {
			for (Entry<String, ClassInSchool> classEntry : classes.entrySet()) {
				Subject s = subjectEntry.getValue();
				ClassInSchool c = classEntry.getValue();
				Teacher t = teachersClasses.getTeacher(s, c);
				
				int numberOfClasses = subjectsClasses.getHours(s, c);
				
				while (numberOfClasses > 0) {
					Lesson newLesson = new Lesson(s, t, c);
					schedule.addLesson(newLesson);
					numberOfClasses --;
				}
			}
		}
	}

}
