package sss.io;

import java.util.Scanner;
import java.util.TreeMap;

import sss.scheduler.objects.Subject;

public class SubjectInputReader extends InputReader {
	
	protected static TreeMap<String, Subject> subjects;

	protected void readLine(String line) {
		Scanner lineScanner;
		boolean homework;
		
		lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String name = lineScanner.next();
		String code = lineScanner.next();
		int homeworkString = lineScanner.nextInt();
		
		if (homeworkString == 0) {
			homework = false;
		} else {
			homework = true;
		}
		
		lineScanner.close();
		subjects.put(code, new Subject(name, code, homework));
	}
	
	public TreeMap<String, Subject> read(String filePath) {
		subjects = new TreeMap<String, Subject>();
		readFile(filePath);
		System.out.println("Number of subjects read: " +  subjects.size());
		
		return subjects;
	}


}
