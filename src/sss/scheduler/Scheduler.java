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

	protected LessonSelectionKB lessonSelectionKB;
	protected ClassroomTimeslotAllocationKB lessonAllocationKB;
	
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
		createdLessonScheduleKB();
		createdLessonAllocationKB();
		
		while (schedule.containsUnallocatedLessons()) {
			selectLessonToSchedule();
			allocateLessonToClassroomAndTimeslot();
		}
	}
	
	protected void createdLessonScheduleKB() {
		lessonSelectionKB = new LessonSelectionKB(new PriorityConflictSet());
		lessonSelectionKB.tell(schedule);
		for (Lesson lesson : schedule.getUnallocatedLessons()) {
			lessonSelectionKB.tell(lesson);
		}
	}
	
	protected void createdLessonAllocationKB() {
		lessonAllocationKB = new ClassroomTimeslotAllocationKB();
		
		// Add schedule to KB
		lessonAllocationKB.tell(schedule);
		
		// Add classrooms to KB
		for (Entry<String, Classroom> entry : classrooms.entrySet()) {
			lessonAllocationKB.tell(entry.getValue());
		}
		
		// Add hours to KB
		for (LessonHour hour : hours) {
			lessonAllocationKB.tell(hour);
		}
		
		// Add teachers to KB
		for (Entry<String, Teacher> entry : teachers.entrySet()) {
			lessonAllocationKB.tell(entry.getValue());
		}
	}
	
	
	public void selectLessonToSchedule() {
		lessonSelectionKB.retract(schedule);
		lessonSelectionKB.tell(schedule);
		lessonSelectionKB.run();
	}
	
	public void allocateLessonToClassroomAndTimeslot() {// Add lessons from schedule's conflict set to KB
		for (Lesson lesson : schedule.getSchedulingSet()) {
			lessonAllocationKB.tell(lesson);
		}
		lessonAllocationKB.run();
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

	public Schedule getSchedule() {
		return schedule;
	}

}
