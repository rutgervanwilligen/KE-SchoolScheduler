package sss.mvc;

import java.util.ArrayList;
import java.util.TreeMap;

import sss.io.InputReader;
import sss.io.OutputWriter;
import sss.scheduler.Scheduler;
import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.TeacherClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class Model implements Runnable {
	
	protected static TreeMap<String, Teacher> teachers;
	protected static TreeMap<String, ClassInSchool> classes;
	protected static TreeMap<String, Subject> subjects;
	protected static TreeMap<String, Classroom> classrooms;
	protected static ArrayList<LessonHour> hours;
	protected static SubjectClassAllocation subjectsClasses;
	protected static TeacherClassAllocation teachersClasses;
	
	protected Scheduler scheduler;

	public Model() {
		scheduler = new Scheduler();
	}
	
	/**
	 * Read input information from files.
	 * 
	 * @param teacherInputFile String File path to info file about teachers.
	 * @param classesInputFile String File path to info file about classes.
	 */
	private static void readInput(String teacherInputFile, String classesInputFile, 
			String hoursInputFile, String subjectsInputFile, String classroomsInputFile,
			String subjectsClassesInputFile, String teachersClassesInputFile) {
		System.out.println("Reading input files...");
		
		hours = InputReader.readHoursInfo(hoursInputFile);
		subjects = InputReader.readSubjectsInfo(subjectsInputFile);
		teachers = InputReader.readTeachersInfo(teacherInputFile, hours, subjects);
		classrooms = InputReader.readClassroomsInfo(classroomsInputFile, hours, subjects);
		classes = InputReader.readClassesInfo(classesInputFile, hours, teachers);
		subjectsClasses = InputReader.readSubjectsClassesInfo(subjectsClassesInputFile, subjects, classes);
		teachersClasses = InputReader.readTeachersClassesInfo(teachersClassesInputFile, teachers, subjects, classes);
	}

	/**
	 * Create scheduler with all data and start scheduler.
	 */
	private void startScheduler() {
		scheduler.setData(hours, subjects, teachers, 
				classrooms, classes, subjectsClasses, teachersClasses);
		scheduler.createSchedule();
	}

	/**
	 * Create scheduler with all data and start scheduler.
	 */
	public void stopScheduler() {
		scheduler.stopScheduling();
	}

	/**
	 * Prints the created schedule per classroom, class and teacher.
	 */
	public void writeOutput() {
		OutputWriter.writeClassroomSchedulesToFile(scheduler.getSchedule(), classrooms);
		OutputWriter.writeClassSchedulesToFile(scheduler.getSchedule(), classes);
		OutputWriter.writeTeacherSchedulesToFile(scheduler.getSchedule(), teachers);
		System.out.println("Results have been saved to output folder.");
	}
	
	public void readInputFiles(String[] args) {
		String teacherInputFile, classesInputFile, hoursInputFile, subjectsInputFile, 
		classroomsInputFile, subjectsClassesInputFile, teachersClassesInputFile;
		
		if (args.length != 7) {
			printUsage();
		} else {
			teacherInputFile = args[0];
			classesInputFile = args[1];
			hoursInputFile = args[2];
			subjectsInputFile = args[3];
			classroomsInputFile = args[4];
			subjectsClassesInputFile = args[5];
			teachersClassesInputFile = args[6];
			
			readInput(teacherInputFile, classesInputFile, hoursInputFile, subjectsInputFile, 
					classroomsInputFile, subjectsClassesInputFile, teachersClassesInputFile);
		}
	}

	private static void printUsage() {
		System.out.println("Usage: <java Main> with the following arguments:");
		System.out.println("  Teacher input file (docenteninfo.csv)");
		System.out.println("  Classes input file (klasseninfo.csv)");
		System.out.println("  Hours input file (ureninfo.csv");
		System.out.println("  Subjects input file (vakkeninfo.csv)");
		System.out.println("  Classrooms input file (lokaleninfo.csv)");
		System.out.println("  Subjects-classes allocations input file (vakkenurenaantallen.csv");
		System.out.println("  Teachers-classes allocations input file (klassendocenten.csv");
	}

	@Override
	public void run() {
		
		startScheduler();
		writeOutput();
		System.out.println("Done");
	}

	public Schedule getSchedule() {
		return scheduler.getSchedule();
	}

	public boolean isRunning() {
		return scheduler.isRunning();
	}

}
