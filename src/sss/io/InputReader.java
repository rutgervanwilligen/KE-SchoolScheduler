package sss.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.TeacherClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public abstract class InputReader {

	protected void readFile(String filePath) {
		File file = new File(filePath);
		Scanner in;
		
		try {
			in = new Scanner(file);
			in.nextLine(); // Ignore headers
			
			while (in.hasNextLine()) {
				readLine(in.nextLine());
			}
			
			in.close();
								
		} catch (FileNotFoundException e) {
			System.out.println("Error: input " + filePath + "file not found!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	abstract void readLine(String line) throws IOException;

	public static TreeMap<String, Teacher> readTeachersInfo(String filePath, 
			ArrayList<LessonHour> hours, TreeMap<String, Subject> subjects) {
		TeacherInputReader reader = new TeacherInputReader(hours, subjects);
		return reader.read(filePath);
	}

	public static TreeMap<String, ClassInSchool> readClassesInfo(String filePath, 
			ArrayList<LessonHour> hours, TreeMap<String, Teacher> teachers) {
		ClassInputReader reader = new ClassInputReader(hours, teachers);
		return reader.read(filePath);
	}

	public static TreeMap<String, Subject> readSubjectsInfo(String filePath) {
		SubjectInputReader reader = new SubjectInputReader();
		return reader.read(filePath);
	}
	
	public static TreeMap<String, Classroom> readClassroomsInfo(String filePath, ArrayList<LessonHour> hours, 
			TreeMap<String, Subject> subjects) {
		ClassroomInputReader reader = new ClassroomInputReader(hours, subjects);
		return reader.read(filePath);
	}
	
	public static SubjectClassAllocation readSubjectsClassesInfo(String filePath, 
			TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		SubjectsClassesInputReader reader = new SubjectsClassesInputReader(subjects, classes);
		return reader.read(filePath);
	}
	
	public static TeacherClassAllocation readTeachersClassesInfo(String filePath, TreeMap<String, Teacher> teachers,
			TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		TeachersClassesInputReader reader = new TeachersClassesInputReader(teachers, subjects, classes);
		return reader.read(filePath);
	}
	
	public static ArrayList<LessonHour> readHoursInfo(String filePath) {
		HourInputReader reader = new HourInputReader();
		return reader.read(filePath);
	}
}
