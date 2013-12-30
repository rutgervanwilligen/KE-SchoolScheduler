package sss;
import java.util.ArrayList;
import java.util.TreeMap;

import sss.io.InputReader;
import sss.scheduler.Scheduler;
import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.TeacherClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class Main {
	
	protected static TreeMap<String, Teacher> teachers;
	protected static TreeMap<String, ClassInSchool> classes;
	protected static TreeMap<String, Subject> subjects;
	protected static TreeMap<String, Classroom> classrooms;
	protected static ArrayList<LessonHour> hours;
	protected static SubjectClassAllocation subjectsClasses;
	protected static TeacherClassAllocation teachersClasses;

	/**
	 * Read input information from files.
	 * 
	 * @param teacherInputFile String File path to info file about teachers.
	 * @param classesInputFile String File path to info file about classes.
	 */
	private static void readInput(String teacherInputFile, String classesInputFile, 
			String hoursInputFile, String subjectsInputFile, String classroomsInputFile,
			String subjectsClassesInputFile, String teachersClassesInputFile) {
		hours = InputReader.readHoursInfo(hoursInputFile);
		subjects = InputReader.readSubjectsInfo(subjectsInputFile);
		teachers = InputReader.readTeachersInfo(teacherInputFile, hours, subjects);
		classrooms = InputReader.readClassroomsInfo(classroomsInputFile, subjects);
		classes = InputReader.readClassesInfo(classesInputFile, teachers);
		subjectsClasses = InputReader.readSubjectsClassesInfo(subjectsClassesInputFile, subjects, classes);
		teachersClasses = InputReader.readTeachersClassesInfo(teachersClassesInputFile, teachers, subjects, classes);
	}

	/**
	 * Create scheduler, set required data and start scheduler.
	 */
	private static void startScheduler() {
		Scheduler scheduler = new Scheduler();
		
		scheduler.setTeachers(teachers);
		scheduler.setClasses(classes);
		
		scheduler.createSchedule();
	}

	/**
	 * Ask what output to write and print it?
	 */
	private static void writeOutput() {
		
	}
	
	public static void main(String[] args) {
		String teacherInputFile, classesInputFile, hoursInputFile, subjectsInputFile, 
		classroomsInputFile, subjectsClassesInputFile, teachersClassesInputFile;
		
		if (args.length != 2) {
			printUsage();
		} else {
			teacherInputFile = args[0];
			classesInputFile = args[1];
			hoursInputFile = "dummy";
			subjectsInputFile = "dummy";
			classroomsInputFile = "dummy";
			subjectsClassesInputFile = "dummy";
			teachersClassesInputFile = "dummy";
//			hoursInputFile = args[2];
			
			readInput(teacherInputFile, classesInputFile, hoursInputFile, subjectsInputFile, 
					classroomsInputFile, subjectsClassesInputFile, teachersClassesInputFile);
			startScheduler();
			writeOutput();
		}
		
		System.out.println("Done");
	}

	private static void printUsage() {
		System.out.println("You are doing it wrong!");
	}

}
