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
		Scanner lineScanner;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		lineScanner.close();
	
	//	TODO Parsen uit vakkenurenaantallen.csv. Nogal lastig ivm onleesbare/variabele kolommen.	
	//	subjectsClasses.allocateHours(subjectString, classString, n);
	}
	
	public SubjectClassAllocation read(String filePath) {
		subjectsClasses = new SubjectClassAllocation(subjects, classes);
		readFile(filePath);
		
		System.out.println("Done with subjects-classes allocations");
		return subjectsClasses;
	}
	
	
}
