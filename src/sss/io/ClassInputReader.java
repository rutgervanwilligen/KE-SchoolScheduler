package sss.io;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.HigherClass;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Level;
import sss.scheduler.objects.LowerClass;
import sss.scheduler.objects.Teacher;

public class ClassInputReader extends InputReader {
	
	protected static TreeMap<String, ClassInSchool> classes;
	protected static TreeMap<String, Teacher> teachers;
	protected static ArrayList<LessonHour> hours;
	
	public ClassInputReader (ArrayList<LessonHour> hours, TreeMap<String, Teacher> teachers) {
		ClassInputReader.hours = hours;
		ClassInputReader.teachers = teachers;
	}
	
	protected void readLine(String line) {
		Scanner lineScanner;
		Level level;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		String levelString = lineScanner.next();
		int year = Integer.valueOf(lineScanner.next());
		char letter = lineScanner.next().charAt(0);
		int size = Integer.valueOf(lineScanner.next());
		
		String mentorString = lineScanner.next();
		Teacher mentor = teachers.get(mentorString);
					
		lineScanner.close();
		
		if (levelString.equals("H")) {
			level = Level.HAVO;
		} else {
			level = Level.VWO;
		}
		
		if (year <= 3) {
			classes.put(name, new LowerClass(name, level, year, letter, mentor, size, hours.size()));
		} else {
			classes.put(name, new HigherClass(name, level, year, letter, mentor, size, hours.size()));
		}
	}

	public TreeMap<String, ClassInSchool> read(String filePath) {
		classes = new TreeMap<String, ClassInSchool>();
		
		readFile(filePath);
		System.out.println("Number of classes read: " +  classes.size());
		
		return classes;
	}
	
}
