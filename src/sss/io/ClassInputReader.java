package sss.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.HigherClass;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.LowerClass;
import sss.scheduler.objects.Teacher;
import sss.scheduler.properties.Level;

public class ClassInputReader extends InputReader {
	
	protected static TreeMap<String, ClassInSchool> classes;
	protected static TreeMap<String, Teacher> teachers;
	protected static ArrayList<LessonHour> hours;
	
	public ClassInputReader (ArrayList<LessonHour> hours, TreeMap<String, Teacher> teachers) {
		ClassInputReader.hours = hours;
		ClassInputReader.teachers = teachers;
	}
	
	protected void readLine(String line) throws IOException {
		Scanner lineScanner;
		Level level;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		
		char levelChar = lineScanner.next().charAt(0);
		
		int year = Integer.valueOf(lineScanner.next());
		char letter = lineScanner.next().charAt(0);
		int size = Integer.valueOf(lineScanner.next());
		
		String mentorString = lineScanner.next();
		Teacher mentor = teachers.get(mentorString);
		if (mentor == null) {
			lineScanner.close();
			throw(new IOException("Mentor " + mentorString + " for class " + name + " cannot be found in teachers."));
		}
							
		lineScanner.close();
		
		if (levelChar == 'H') {
			level = Level.HAVO;
		} else if (levelChar == 'A') {
			level = Level.ATHENEUM;
		} else if (levelChar == 'G') {
			level = Level.GYMNASIUM;
		} else {
			throw(new IOException("Read unexpected level for " + name + "in ClassInputReader."));
		}
		
		if (year < HigherClass.LOWER_BOUND) {
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
