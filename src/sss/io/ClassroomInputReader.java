package sss.io;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.Location;
import sss.scheduler.objects.Subject;

public class ClassroomInputReader extends InputReader {
	
	protected static TreeMap<String, Classroom> classrooms;
	protected static TreeMap<String, Subject> subjects;
	
	public ClassroomInputReader (TreeMap<String, Subject> subjects) {
		ClassroomInputReader.subjects = subjects;
	}
	
	protected void readLine(String line) {
		Scanner lineScanner, facilityScanner;
		boolean general = false;
		boolean computers = false;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		int capacity = lineScanner.nextInt();
		
		String locationString = lineScanner.next();
		Location location;
		
		if (locationString.equals("HG")) {
			location = Location.HG;
		} else {
			location = Location.DEP;
		}
		
		int floor = lineScanner.nextInt();
		
		String facilityString = lineScanner.next();
		
		ArrayList<Subject> facilities = new ArrayList<Subject>();
		
		facilityScanner = new Scanner(facilityString);
		facilityScanner.useDelimiter("|");
		
		while (facilityScanner.hasNext()) {
			String next = facilityScanner.next();
			if (next.equals("ALG")) {
				general = true;
			} else if (next.equals("CP")) {
				computers = true;
			} else {
				facilities.add(subjects.get(next));
			}
		}
		
		lineScanner.close();
		facilityScanner.close();
		
		classrooms.put(name, new Classroom(name, capacity, location, floor, general, computers, facilities));
	}

	public TreeMap<String, Classroom> read(String filePath) {
		classrooms = new TreeMap<String, Classroom>();
		
		readFile(filePath);
		System.out.println("Number of classrooms read: " +  classrooms.size());
		
		return classrooms;
	}
	
}
