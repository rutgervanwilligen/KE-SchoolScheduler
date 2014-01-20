package sss.io;

import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.TeacherClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class TeachersClassesInputReader extends InputReader {

	protected static TreeMap<String, Subject> subjects;
	protected static TreeMap<String, ClassInSchool> classes;
	protected static TreeMap<String, Teacher> teachers;
	protected static TeacherClassAllocation teachersClasses;
	
	public TeachersClassesInputReader (TreeMap<String, Teacher> teachers,
			TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		TeachersClassesInputReader.subjects = subjects;
		TeachersClassesInputReader.classes = classes;
		TeachersClassesInputReader.teachers = teachers;
	}
	
	protected void readLine(String line) {
		Scanner lineScanner;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String className = lineScanner.next();
		
		while (lineScanner.hasNext()) {
			String tupleString = lineScanner.next();
			
			if (tupleString.length() > 0) {
				String[] tuple = lineScanner.next().split("-");
				
				String subjectCode = tuple[0];
				String teacherCode = tuple[1];
				
				teachersClasses.allocateTeacher(teacherCode, subjectCode, className);
			}
		}
		
		lineScanner.close();
	}
	
	public TeacherClassAllocation read(String filePath) {
		teachersClasses = new TeacherClassAllocation(teachers, subjects, classes);
		readFile(filePath);
		
		System.out.println("Done with teachers-classes allocations");
		return teachersClasses;
	}

}
