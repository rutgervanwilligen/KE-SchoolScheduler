package sss.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.SubjectClassAllocation;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;
import sss.scheduler.properties.Level;

public class SubjectsClassesInputReader extends InputReader {

	protected static TreeMap<String, Subject> subjects;
	protected static TreeMap<String, ClassInSchool> classes;
	protected static SubjectClassAllocation subjectsClasses;
	
	public SubjectsClassesInputReader (TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		SubjectsClassesInputReader.subjects = subjects;
		SubjectsClassesInputReader.classes = classes;
	}
	
	protected void readLine(String line) throws IOException {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String subjectString = lineScanner.next();
		
		while (lineScanner.hasNext()) {
			String unit = lineScanner.next();
			parseUnit(unit, subjectString);
		}
		
		lineScanner.close();
	}
	
	protected void parseUnit(String unit, String subjectString) throws IOException {
		Scanner unitScanner = new Scanner(unit);
		unitScanner.useDelimiter("\\|");
		
		String classString = unitScanner.next();
		ArrayList<ClassInSchool> classesToAllocateFor = getClassesFromString(classString);
		
		ArrayList<String> hourNeeds = new ArrayList<String>();
		
		while (unitScanner.hasNext()) {
			hourNeeds.add(unitScanner.next());
		}
		
		for (ClassInSchool c : classesToAllocateFor) {
			subjectsClasses.allocateHourNeeds(subjectString, c.getName(), hourNeeds);			
		}
		unitScanner.close();
	}
	
	
	public ArrayList<ClassInSchool> getClassesFromString(String classString) throws IOException {
		ArrayList<ClassInSchool> result = new ArrayList<ClassInSchool>();
		
		char levelChar = classString.charAt(0);
		int year = Character.getNumericValue(classString.charAt(1));
		Level level = null;
		
		if (levelChar == 'H') {
			level = Level.HAVO;
		} else if (levelChar == 'A') {
			level = Level.ATHENEUM;
		} else if (levelChar == 'G') {
			level = Level.GYMNASIUM;
		} else {
			throw(new IOException("Level found in " + classString + " could not be parsed."));
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
