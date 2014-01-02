package sss.io;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Level;
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
		unitScanner.useDelimiter("\\|");
		
		String classString = unitScanner.next();
		ArrayList<ClassInSchool> classesToAllocateFor = getClassesFromString(classString);
		
		int hourCount = unitScanner.nextInt();
		
		for (ClassInSchool c : classesToAllocateFor) {
			subjectsClasses.allocateHours(subjectString, c.getName(), hourCount);			
		}
		unitScanner.close();
	}
	
	
	public ArrayList<ClassInSchool> getClassesFromString(String classString) {
		ArrayList<ClassInSchool> result = new ArrayList<ClassInSchool>();
		
		char levelChar = classString.charAt(0);
		int year = Character.getNumericValue(classString.charAt(1));
		Level level = null;
		
		if (levelChar == 'H') {
			level = Level.HAVO;
		} else if (levelChar == 'V') {
			level = Level.VWO;
		}
		
		for (Entry<String, ClassInSchool> classEntry : classes.entrySet()) {
			ClassInSchool entry = classEntry.getValue();
			if (entry.getLevel() == level && entry.getYear() == year) {
				result.add(entry);
			}
		}
		
		return result;
	}
	
	public SubjectClassAllocation read(String filePath) {
		subjectsClasses = new SubjectClassAllocation(subjects, classes);
		readFile(filePath);
		
		System.out.println("Done with subjects-classes allocations");
		return subjectsClasses;
	}
	
	
}
