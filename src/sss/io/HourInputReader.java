package sss.io;

import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.LessonHour;

public class HourInputReader extends InputReader {
	
	protected static ArrayList<LessonHour> hours;
	
	protected void readLine(String line) {
		Scanner beginTimeScanner, endTimeScanner, lineScanner;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		int number = lineScanner.nextInt();

		String beginTime = lineScanner.next();
		String endTime = lineScanner.next();
		
		beginTimeScanner = new Scanner(beginTime);
		beginTimeScanner.useDelimiter(":");
		int beginTimeHours = beginTimeScanner.nextInt();
		int beginTimeMinutes = beginTimeScanner.nextInt();
		
		endTimeScanner = new Scanner(endTime);
		endTimeScanner.useDelimiter(":");
		int endTimeHours = endTimeScanner.nextInt();
		int endTimeMinutes = endTimeScanner.nextInt();
		
		lineScanner.close();
		beginTimeScanner.close();
		endTimeScanner.close();
		
		hours.add(new LessonHour(number, beginTimeHours, beginTimeMinutes, endTimeHours, endTimeMinutes));
	}
	
	public ArrayList<LessonHour> read(String filePath) {
		hours = new ArrayList<LessonHour>();
		readFile(filePath);
		System.out.println("Number of hours read: " +  hours.size());
		
		return hours;
	}

}
