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
import sss.scheduler.properties.ClockValue;
import sss.scheduler.properties.Weekday;

public class OutputWriter {

	protected static Schedule schedule;
	protected TreeMap<String, ClassInSchool> classes;
	
	public static void writeClassroomSchedulesToFile(Schedule schedule, TreeMap<String, Classroom> classrooms) {
		try {
			PrintWriter writer = new PrintWriter("output/classroomSchedules.csv", "UTF-8");

			Collections.sort(Scheduler.hours);

			for (Entry<String, Classroom> entry : classrooms.entrySet()) {
				ClockValue startingHour;
				Weekday weekday;
				Classroom classroom = entry.getValue();
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();
				ArrayList<ClockValue> clockValues = ClockValue.getUniqueStartingClockValues(Scheduler.hours);
				String scheduleString = printHeader(classroom.getRoomNumber());
				
				Collections.sort(lessons);
				
				for (ClockValue clockValue : clockValues) {
					for (LessonHour lessonHour : Scheduler.hours) {
						startingHour = lessonHour.getStartTime();
						weekday = lessonHour.getWeekday();
						
						bla: if (startingHour.equals(clockValue)) {
							if (!weekday.equals(Weekday.MONDAY)) {
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(classroom) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							} else {
								scheduleString += writeStartRow(lessonHour);
								
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(classroom) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							}
							
							scheduleString += writeOpenSlot(lessonHour, classroom.getAvailability(lessonHour) + "");
						}
					}
				}
				
				scheduleString+= "\n\n";
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
		try {
			PrintWriter writer = new PrintWriter("output/classSchedules.csv", "UTF-8");

			Collections.sort(Scheduler.hours);

			for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
				ClockValue startingHour;
				Weekday weekday;
				ClassInSchool classInSchool = entry.getValue();
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();
				ArrayList<ClockValue> clockValues = ClockValue.getUniqueStartingClockValues(Scheduler.hours);
				String scheduleString = printHeader(classInSchool.getName());
				
				Collections.sort(lessons);
				
				for (ClockValue clockValue : clockValues) {
					for (LessonHour lessonHour : Scheduler.hours) {
						startingHour = lessonHour.getStartTime();
						weekday = lessonHour.getWeekday();
						
						bla: if (startingHour.equals(clockValue)) {
							if (!weekday.equals(Weekday.MONDAY)) {
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(classInSchool) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							} else {
								scheduleString += writeStartRow(lessonHour);
								
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(classInSchool) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							}
							
							scheduleString += writeOpenSlot(lessonHour, classInSchool.getTypeOfHour(lessonHour));
						}
					}
				}
				
				scheduleString+= "\n\n";
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

			Collections.sort(Scheduler.hours);

			for (Entry<String, Teacher> entry : teachers.entrySet()) {
				ClockValue startingHour;
				Weekday weekday;
				Teacher teacher = entry.getValue();
				ArrayList<Lesson> lessons = schedule.getAllocatedLessons();
				ArrayList<ClockValue> clockValues = ClockValue.getUniqueStartingClockValues(Scheduler.hours);
				String scheduleString = printHeader(teacher.getName());
				
				Collections.sort(lessons);
				
				for (ClockValue clockValue : clockValues) {
					for (LessonHour lessonHour : Scheduler.hours) {
						startingHour = lessonHour.getStartTime();
						weekday = lessonHour.getWeekday();
						
						bla: if (startingHour.equals(clockValue)) {
							if (!weekday.equals(Weekday.MONDAY)) {
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(teacher) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							} else {
								scheduleString += writeStartRow(lessonHour);
								
								for (Lesson lesson : lessons) {
									if (lesson.isAllocatedTo(teacher) && lesson.isAllocatedTo(lessonHour)) {
										scheduleString += writeSlot(lesson);
										break bla;
									}
								}
							}
							
							scheduleString += writeOpenSlot(lessonHour, teacher.getAvailability(lessonHour) + "");
						}
					}
				}
				
				scheduleString+= "\n\n";
				writer.print(scheduleString);
			}
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	protected static String writeOpenLesson(LessonHour lessonHour, String string) {
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

	protected static String writeStartRow(LessonHour lessonHour) {
		return "\n" + lessonHour.getHour() + " - " +
				lessonHour.getStartTime().getHours() + ":" + lessonHour.getStartTime().getMinutes() + "-" + 
				lessonHour.getEndTime().getHours() + ":" + lessonHour.getEndTime().getMinutes() + ", ";
	}

	protected static String printHeader(String name) {
		String headerString = name + ",";
		for (Weekday weekday : Weekday.values()) {
			headerString += weekday + ",";
		}
		return headerString;
	}

	protected static String writeSlot(Lesson lesson) {
		String result = 
					lesson.getClassInSchool().getName() + " - " +
					lesson.getSubject().getName() + " - " +
					lesson.getTeacher().getName() + " - " +
					lesson.getClassroom().getRoomNumber() + ",";
		return result;
	}
	
	protected static String writeOpenSlot(LessonHour lessonHour, String string) {
		return string + ",";
	}
}
