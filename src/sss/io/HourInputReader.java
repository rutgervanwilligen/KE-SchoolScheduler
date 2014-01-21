package sss.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.LessonHour;
import sss.scheduler.properties.ClockValue;
import sss.scheduler.properties.Weekday;

public class HourInputReader extends InputReader {
	
	protected static ArrayList<LessonHour> hours;
	
	protected void readLine(String line) throws IOException {
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
		
		getDaysAndAddHours(lineScanner.next(), number, beginTimeHours, beginTimeMinutes, endTimeHours, endTimeMinutes);
		
		lineScanner.close();
		beginTimeScanner.close();
		endTimeScanner.close();
		
	}
	
	public void getDaysAndAddHours(String days, int number, int beginTimeHours, int beginTimeMinutes,
			int endTimeHours, int endTimeMinutes) throws IOException {
		
		Scanner daysScanner = new Scanner(days);
		daysScanner.useDelimiter("\\|");
		
		while (daysScanner.hasNext()) {
			Weekday weekday = getWeekday(daysScanner.next());
			hours.add(new LessonHour(weekday, number, beginTimeHours, beginTimeMinutes, endTimeHours, endTimeMinutes));	
		}
	}
	
	public Weekday getWeekday(String day) throws IOException {
		if (day.equals("MA")) {
			return Weekday.MONDAY;
		} else if (day.equals("DI")) {
			return Weekday.TUESDAY;
		} else if (day.equals("WO")) {
			return Weekday.WEDNESDAY;
		} else if (day.equals("DO")) {
			return Weekday.THURSDAY;
		} else if (day.equals("VR")) {
			return Weekday.FRIDAY;
		} else {
			throw(new IOException("Weekday " + day + " could not be parsed."));
		}
	}
	
	public ArrayList<LessonHour> read(String filePath) {
		hours = new ArrayList<LessonHour>();
		readFile(filePath);
		
		addNextHours();
		System.out.println("Number of hours read: " +  hours.size());
		
		return hours;
	}

	public void addNextHours() {
		for (LessonHour hour : hours) {
			Weekday weekday = hour.getWeekday();
			ClockValue endTime = hour.getEndTime();
			
			for (LessonHour nextHour : hours) {
				if (nextHour.getWeekday().equals(weekday) && nextHour.getHour() == (hour.getHour() + 1)) {
					hour.addNextHour(nextHour);
					
					if (endTime.equals(nextHour.getStartTime())) {
						hour.setPreferredForDoubleHour(true);
					} else {
						hour.setPreferredForDoubleHour(false);
					}
					
				}
			}
		}
	}
	
}
