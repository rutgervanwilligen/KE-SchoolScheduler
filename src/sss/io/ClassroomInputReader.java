package sss.io;

import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.HigherClass;
import sss.scheduler.objects.Level;
import sss.scheduler.objects.Location;
import sss.scheduler.objects.LowerClass;
import sss.scheduler.objects.Subject;

public class ClassroomInputReader extends InputReader {
	
	protected static ArrayList<Classroom> classrooms;
	
	protected void readLine(String line) {
		Scanner lineScanner, facilityScanner;
		
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
			// TODO Beter hiermee omgaan, wellicht opzoeken of die al bestaat ipv nieuwe aanmaken,
			// zie ik nog niet goed voor me
			facilities.add(new Subject(facilityScanner.next(), "a", false));
		}
		
		lineScanner.close();
		facilityScanner.close();
		
		classrooms.add(new Classroom(name, capacity, location, floor, facilities));
	}

	public ArrayList<Classroom> read(String filePath) {
		classrooms = new ArrayList<Classroom>();
		
		readFile(filePath);
		System.out.println("Number of classrooms read: " +  classrooms.size());
		
		return classrooms;
	}
	
}
