package sss.io;

import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class TeacherInputReader extends InputReader {
	
	protected static ArrayList<Teacher> teachers;
	
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
		
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		subjectScanner = new Scanner(subjectString);
		subjectScanner.useDelimiter("|");
		
		while (subjectScanner.hasNext()) {
			// TODO Beter hiermee omgaan, wellicht opzoeken of die al bestaat ipv nieuwe aanmaken,
			// zie ik nog niet goed voor me
			subjects.add(new Subject(subjectScanner.next()));
		}
		
		lineScanner.close();
		subjectScanner.close();
		
		teachers.add(new Teacher(name, code, weeklyHours, subjects, grade, availableHours, unavailableHours, undesiredHours));
		System.out.println("Read teacher " + name);
	}
	
	public ArrayList<Teacher> read(String filePath) {
		teachers = new ArrayList<Teacher>();
		readFile(filePath);
		System.out.println("Number of teachers read: " +  teachers.size());
		
		return teachers;
	}

}
