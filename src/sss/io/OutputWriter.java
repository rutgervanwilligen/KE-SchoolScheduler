package sss.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import sss.scheduler.Scheduler;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.DoubleHourLesson;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Teacher;
import sss.scheduler.properties.Availability;

public class OutputWriter {

	protected static Schedule schedule;
	protected TreeMap<String, ClassInSchool> classes;
	
	public static void writeClassroomSchedulesToFile(Schedule schedule, TreeMap<String, Classroom> classrooms) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output/classroomSchedules.csv", "UTF-8");
			for (Entry<String, Classroom> entry : classrooms.entrySet()) {
				Classroom classroom = entry.getValue();
				String scheduleString = classroom.getRoomNumber() + "\n";
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();

				Collections.sort(lessons);
				Collections.sort(Scheduler.hours);
				
				lessonHourLoop: for (int i = 0; i < Scheduler.hours.size(); i++) {
					LessonHour lessonHour = Scheduler.hours.get(i);
					for (Lesson lesson : lessons) {
						if (lesson.isAllocatedTo(classroom) && lesson.isAllocatedTo(lessonHour)) {
							scheduleString += writeLesson(lesson);
							if (lesson.isDoubleHour())
								i++;
							continue lessonHourLoop;
						}
					}
					scheduleString += writeOpenSlot(lessonHour, "" + classroom.getAvailability(lessonHour));
				}
				
				scheduleString+= "\n";
				writer.print(scheduleString);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void writeClassSchedulesToFile(Schedule schedule, TreeMap<String, ClassInSchool> classes) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output/classSchedules.csv", "UTF-8");
			for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
				ClassInSchool classInSchool = entry.getValue();
				String scheduleString = classInSchool.getName() + "\n";
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();
				
				Collections.sort(lessons);
				Collections.sort(Scheduler.hours);
				
				lessonHourLoop: for (int i = 0; i < Scheduler.hours.size(); i++) {
					LessonHour lessonHour = Scheduler.hours.get(i);
					for (Lesson lesson : lessons) {
						if (lesson.isAllocatedTo(classInSchool) && lesson.isAllocatedTo(lessonHour)) {
							scheduleString += writeLesson(lesson);
							if (lesson.isDoubleHour())
								i++;
							continue lessonHourLoop;
						}
					}
					scheduleString += writeOpenSlot(lessonHour, classInSchool.getTypeOfHour(lessonHour));
				}
				
				scheduleString+= "\n";
				writer.print(scheduleString);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void writeTeacherSchedulesToFile(Schedule schedule, TreeMap<String, Teacher> teachers) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output/teacherSchedules.csv", "UTF-8");
			for (Entry<String, Teacher> entry : teachers.entrySet()) {
				Teacher teacher = entry.getValue();
				String scheduleString = teacher.getName() + " - " + teacher.getCode() + "\n";
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();
				
				Collections.sort(lessons);
				Collections.sort(Scheduler.hours);
				
				lessonHourLoop: for (int i = 0; i < Scheduler.hours.size(); i++) {
					LessonHour lessonHour = Scheduler.hours.get(i);
					for (Lesson lesson : lessons) {
						if (lesson.isAllocatedTo(teacher) && lesson.isAllocatedTo(lessonHour)) {
							scheduleString += writeLesson(lesson);
							if (lesson.isDoubleHour())
								i++;
							continue lessonHourLoop;
						}
					}
					scheduleString += writeOpenSlot(lessonHour, "" + teacher.getAvailability(lessonHour));
				}
				
				scheduleString+= "\n";
				writer.print(scheduleString);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	protected static String writeOpenSlot(LessonHour lessonHour, String string) {
		return lessonHour.getWeekday().name() + ", " +
				lessonHour.getHour() + ", " +
				lessonHour.getStartTime().getHours() + ":" + lessonHour.getStartTime().getMinutes() + "-" + 
				lessonHour.getEndTime().getHours() + ":" + lessonHour.getEndTime().getMinutes() + ", " +
				string + "\n";
	}

	protected static String writeLesson(Lesson lesson) {
		String result = lesson.getWeekday().name() + ", " +
					lesson.getHour().getHour() + ", " +
					lesson.getHour().getStartTime().getHours() + ":" + lesson.getHour().getStartTime().getMinutes() + "-" + 
					lesson.getHour().getEndTime().getHours() + ":" + lesson.getHour().getEndTime().getMinutes() + ", " +
					lesson.getClassInSchool().getName() + ", " +
					lesson.getSubject().getName() + ", " +
					lesson.getTeacher().getName() + ", " +
					lesson.getClassroom().getRoomNumber() + "\n";
		if (lesson instanceof DoubleHourLesson) {
			result += lesson.getWeekday().name() + ", " +
					lesson.getHour().getHour() + ", " +
					lesson.getHour().getNextHour().getStartTime().getHours() + ":" + lesson.getHour().getNextHour().getStartTime().getMinutes() + "-" + 
					lesson.getHour().getNextHour().getEndTime().getHours() + ":" + lesson.getHour().getNextHour().getEndTime().getMinutes() + ", " +
					lesson.getClassInSchool().getName() + ", " +
					lesson.getSubject().getName() + ", " +
					lesson.getTeacher().getName() + ", " +
					lesson.getClassroom().getRoomNumber() + "\n";
		}
		return result;
	}
}
