package sss.io;

import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.HigherClass;
import sss.scheduler.objects.Level;
import sss.scheduler.objects.LowerClass;

public class ClassInputReader extends InputReader {
	
	protected static ArrayList<ClassInSchool> classes;
	
	protected void readLine(String line) {
		Scanner lineScanner, subjectScanner;
		Level level;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		int year = Integer.valueOf(lineScanner.next());
		String levelString = lineScanner.next();
		int size = Integer.valueOf(lineScanner.next());
		String mentor = lineScanner.next();
		String courses = lineScanner.next();
			
		lineScanner.close();
		
		if (levelString.equals('H')) {
			level = Level.HAVO;
		} else {
			level = Level.VWO;
		}
		
		if (year <= 3) {
			classes.add(new LowerClass(year, 'a', level));
		} else {
			classes.add(new HigherClass(year, 'a', level));
		}

		System.out.println("Read class " + name);
	}

	public ArrayList<ClassInSchool> read(String filePath) {
		classes = new ArrayList<ClassInSchool>();
		
		readFile(filePath);
		System.out.println("Number of classes read: " +  classes.size());
		
		return classes;
	}
	
}
