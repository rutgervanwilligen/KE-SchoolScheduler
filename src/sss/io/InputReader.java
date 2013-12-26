package sss.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public abstract class InputReader {
	
	/**
	 * Read input file with teacher information
	 * @param filePath String Path to file with teacher information.<br>Input file should be in .CSV format, fields delimited by semicolon.<br>Fields should be in the following order: Name;Code;Subject[|Anothersubject];WeeklyHours;AvailableHours;UnavailableHours;UndesiredHours;
	 * @return ArrayList<Teacher> List of teachers
	 */
	protected void readFile(String filePath) {
		// TODO Graag even verifieren of dit niet toevallig ook mooier kan, ik vind het echt een draak namelijk
		ArrayList<Teacher> result = new ArrayList<Teacher>();
		File file = new File(filePath);
		Scanner in;
		
		try {
			in = new Scanner(file);
			in.nextLine(); // Ignore headers
			
			while (in.hasNextLine()) {
				readLine(in.nextLine());
			}
			
			in.close();
								
		} catch (FileNotFoundException e) {
			System.out.println("Error: input file not found!");
			System.exit(1);
		}
	}
	
	abstract void readLine(String line);

	public static ArrayList<Teacher> readTeachers(String filePath) {
		TeacherInputReader reader = new TeacherInputReader();
		return reader.read(filePath);
	}

	public static ArrayList<ClassInSchool> readClasses(String filePath) {
		ClassInputReader reader = new ClassInputReader();
		return reader.read(filePath);
	}

	public static ArrayList<LessonHour> readHoursInfo(String filePath) {
		HourInputReader reader = new HourInputReader();
		return reader.read(filePath);
	}

}
