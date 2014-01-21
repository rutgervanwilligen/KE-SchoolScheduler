package sss;
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
	
	protected static Scheduler scheduler;

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
		classrooms = InputReader.readClassroomsInfo(classroomsInputFile, hours, subjects);
		classes = InputReader.readClassesInfo(classesInputFile, hours, teachers);
		subjectsClasses = InputReader.readSubjectsClassesInfo(subjectsClassesInputFile, subjects, classes);
		teachersClasses = InputReader.readTeachersClassesInfo(teachersClassesInputFile, teachers, subjects, classes);
	}

	/**
	 * Create scheduler with all data and start scheduler.
	 */
	private static void startScheduler() {
		scheduler = new Scheduler(hours, subjects, teachers, 
				classrooms, classes, subjectsClasses, teachersClasses);
		scheduler.createSchedule();
	}

	/**
	 * Prints the created schedule per classroom, class and teacher.
	 */
	public static void writeOutput() {
		OutputWriter.writeClassroomSchedulesToFile(scheduler.getSchedule(), classrooms);
		OutputWriter.writeClassSchedulesToFile(scheduler.getSchedule(), classes);
		OutputWriter.writeTeacherSchedulesToFile(scheduler.getSchedule(), teachers);
	}
	
	public static void main(String[] args) {
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
			startScheduler();
			writeOutput();
			System.out.println("Done");
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

}
