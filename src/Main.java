import java.util.ArrayList;


public class Main {
	
	protected static ArrayList<Teacher> teachers;
	protected static ArrayList<ClassInSchool> classes;

	/**
	 * Read input information from files.
	 * 
	 * @param teacherInputFile String File path to info file about teachers.
	 * @param classesInputFile String File path to info file about classes.
	 */
	private static void readInput(String teacherInputFile, String classesInputFile) {
		InputReader inputReader = new InputReader();

		teachers = inputReader.readTeachers(teacherInputFile);
		classes = inputReader.readClasses(classesInputFile);
	}

	/**
	 * Create scheduler, set required data and start scheduler.
	 */
	private static void startScheduler() {
		Scheduler scheduler = new Scheduler();
		
		scheduler.setTeachers(teachers);
		scheduler.setClasses(classes);
		
		scheduler.schedule();
	}

	/**
	 * Ask what output to write and print it?
	 */
	private static void writeOutput() {
		
	}
	
	public static void main(String[] args) {
		String teacherInputFile, classesInputFile;
		
		if (args.length != 2) {
			printUsage();
		} else {
			teacherInputFile = args[0];
			classesInputFile = args[1];
			
			readInput(teacherInputFile, classesInputFile);
			startScheduler();
			writeOutput();
		}
	}

	private static void printUsage() {
		System.out.println("You are doing it wrong!");
	}

}
