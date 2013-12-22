import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	
	/**
	 * Read input file with teacher information
	 * @param filePath String Path to file with teacher information.<br>Input file should be in .CSV format, fields delimited by semicolon.<br>Fields should be in the following order: Name;Code;Subject[|Anothersubject];WeeklyHours;AvailableHours;UnavailableHours;UndesiredHours;
	 * @return ArrayList<Teacher> List of teachers
	 */
	public ArrayList<Teacher> readTeachers(String filePath) {
		// TODO Graag even verifieren of dit niet toevallig ook mooier kan, ik vind het echt een draak namelijk
		ArrayList<Teacher> result = new ArrayList<Teacher>();
		File file = new File(filePath);
		Scanner in, lineScanner, subjectScanner;
		
		try {
			in = new Scanner(file);
			
			in.nextLine(); // Ignore headers
			
			while (in.hasNext()) {
				String line = in.nextLine();
				
				lineScanner = new Scanner(line);
				lineScanner.useDelimiter(";");
				
				String name = lineScanner.next();
				String code = lineScanner.next();
				String subjectString = lineScanner.next();
				String grade = lineScanner.next();
				int weeklyHours = lineScanner.nextInt();
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
				
				result.add(new Teacher(name, code, weeklyHours, subjects, grade, availableHours, unavailableHours, undesiredHours));
			}
			
			in.close();
								
		} catch (FileNotFoundException e) {
			System.out.println("Error: Teacher input file not found!");
			System.exit(1);
		}
		
		return result;
	}
	
	/**
	 * Read input file with classroom information
	 * @param filePath String Path to file with classroom information
	 * @return ArrayList<Class> List of classrooms
	 */
	public ArrayList<Classroom> readClassrooms(String filePath) {
		ArrayList<Classroom> result = new ArrayList<Classroom>();
		
		File file = new File(filePath);
		Scanner in, lineScanner, facilityScanner;
		
		try {
			in = new Scanner(file);
			
			in.nextLine(); // Ignore headers
			
			while (in.hasNext()) {
				String line = in.nextLine();
				
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
					facilities.add(new Subject(facilityScanner.next()));
				}
				
				lineScanner.close();
				facilityScanner.close();
				
				result.add(new Classroom(name, capacity, location, floor, facilities));
			}
			
			in.close();
								
		} catch (FileNotFoundException e) {
			System.out.println("Error: Classroom input file not found!");
			System.exit(1);
		}	
		
		return result;
	}
	
	
	/**
	 * Read input file with class information
	 * @param filePath String Path to file with class information
	 * @return ArrayList<Class> List of classes
	 */
	public ArrayList<ClassInSchool> readClasses(String filePath) {
		ArrayList<ClassInSchool> result = new ArrayList<ClassInSchool>();
		
		
		
		return result;
	}

}
