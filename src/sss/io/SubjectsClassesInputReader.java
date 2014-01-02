package sss.io;

import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;

public class SubjectsClassesInputReader extends InputReader {

	protected static TreeMap<String, Subject> subjects;
	protected static TreeMap<String, ClassInSchool> classes;
	protected static SubjectClassAllocation subjectsClasses;
	
	public SubjectsClassesInputReader (TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		SubjectsClassesInputReader.subjects = subjects;
		SubjectsClassesInputReader.classes = classes;
	}
	
	protected void readLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String subjectString = lineScanner.next();
		
		while (lineScanner.hasNext()) {
			String unit = lineScanner.next();
			parseUnit(unit, subjectString);
		}
		
		lineScanner.close();
	}
	
	protected void parseUnit(String unit, String subjectString) {
		Scanner unitScanner = new Scanner(unit);
		unitScanner.useDelimiter("|");
		
		String classString = unitScanner.next();
		int hourCount = unitScanner.nextInt();
		
		subjectsClasses.allocateHours(subjectString, classString, hourCount);
		unitScanner.close();
	}
	
	
	public SubjectClassAllocation read(String filePath) {
		subjectsClasses = new SubjectClassAllocation(subjects, classes);
		readFile(filePath);
		
		System.out.println("Done with subjects-classes allocations");
		return subjectsClasses;
	}
	
	
}
