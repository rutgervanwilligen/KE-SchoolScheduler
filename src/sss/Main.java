package sss;
import java.util.ArrayList;

import sss.io.ClassInputReader;
import sss.io.InputReader;
import sss.io.TeacherInputReader;
import sss.scheduler.Scheduler;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Teacher;


public class Main {
	
	protected static ArrayList<Teacher> teachers;
	protected static ArrayList<ClassInSchool> classes;
	protected static ArrayList<LessonHour> hours;

	/**
	 * Read input information from files.
	 * 
	 * @param teacherInputFile String File path to info file about teachers.
	 * @param classesInputFile String File path to info file about classes.
	 */
	private static void readInput(String teacherInputFile, String classesInputFile, String hoursInputFile) {
		hours = InputReader.readHoursInfo(hoursInputFile);
		teachers = InputReader.readTeachers(teacherInputFile);
		classes = InputReader.readClasses(classesInputFile);
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
		String teacherInputFile, classesInputFile, hoursInputFile;
		
		if (args.length != 3) {
			printUsage();
		} else {
			teacherInputFile = args[0];
			classesInputFile = args[1];
			hoursInputFile = args[2];
			
			readInput(teacherInputFile, classesInputFile, hoursInputFile);
			startScheduler();
			writeOutput();
		}
		
		System.out.println("Done");
	}

	private static void printUsage() {
		System.out.println("You are doing it wrong!");
	}

}
