package sss.io;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.objects.Availability;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class TeacherInputReader extends InputReader {
	
	protected static TreeMap<String, Teacher> teachers;
	protected static TreeMap<String, Subject> subjects;
	protected static ArrayList<LessonHour> hours;
	
	public TeacherInputReader (ArrayList<LessonHour> hours, TreeMap<String, Subject> subjects) {
		TeacherInputReader.subjects = subjects;
		TeacherInputReader.hours = hours;
	}
	
	protected void readLine(String line) {
		Scanner lineScanner, subjectScanner;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		String code = lineScanner.next();
		String subjectString = lineScanner.next();
		String grade = lineScanner.next();
		int weeklyHours = Integer.valueOf(lineScanner.next());
		
		String availableHours = lineScanner.next();
		String unavailableHours = lineScanner.next();
		String undesiredHours = lineScanner.next();
		Availability[] availabilities = parseAvailabilities(availableHours, unavailableHours, undesiredHours);
		
		ArrayList<Subject> subjectArray = new ArrayList<Subject>();
		
		subjectScanner = new Scanner(subjectString);
		subjectScanner.useDelimiter("\\|");
		
		while (subjectScanner.hasNext()) {
			subjectArray.add(subjects.get(subjectScanner.next()));
		}
		
		lineScanner.close();
		subjectScanner.close();
		
		teachers.put(code, new Teacher(name, code, weeklyHours, subjectArray, grade, availabilities));
	}
	
	private Availability[] parseAvailabilities(String available, String unavailable, String undesired) {
		Availability[] result = new Availability[hours.size()];
		Scanner scanner;
		
		if (!available.equals("none")) {
			scanner = new Scanner(available);
			scanner.useDelimiter("\\|");
			while (scanner.hasNext()) {
				result = parseUnit(result, scanner.next(), Availability.YES);
			}
			scanner.close();
		}
		
		if (!unavailable.equals("none")) {
			scanner = new Scanner(unavailable);
			scanner.useDelimiter("\\|");
			while (scanner.hasNext()) {
				result = parseUnit(result, scanner.next(), Availability.NO);
			}
			scanner.close();
		}
		
		if (!undesired.equals("none")) {
			scanner = new Scanner(undesired);
			scanner.useDelimiter("\\|");
			while (scanner.hasNext()) {
				result = parseUnit(result, scanner.next(), Availability.RATHER_NOT);
			}
			scanner.close();
		}
			
		return result;
	}
	
	private Availability[] parseUnit(Availability[] result, String unit, Availability availability) {
		Scanner scanner = new Scanner(unit);
				
		if (unit.contains("-")) { // Unit contains more than 1 availability
			scanner.useDelimiter("-");
			int first = scanner.nextInt() - 1;
			int last = scanner.nextInt() - 1;
			for (int i=first; i<=last; i++) {
				result[i] = availability;
			}
		} else { // Unit consists of one single availability
			result[scanner.nextInt() - 1] = availability;
		}
		
		return result;
	}
	
	public TreeMap<String, Teacher> read(String filePath) {
		teachers = new TreeMap<String, Teacher>();
		readFile(filePath);
		System.out.println("Number of teachers read: " +  teachers.size());
		
		return teachers;
	}

}
