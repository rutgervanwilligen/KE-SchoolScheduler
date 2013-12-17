import java.util.TreeMap;


public class TeacherClassAllocation {

	private Teacher[][] matrix;
	private TreeMap<Subject, Integer> subjectMap;
	private TreeMap<Class, Integer> classMap;
	
	public TeacherClassAllocation (int nTeachers, int nClasses) {
		matrix = new Teacher[nTeachers][nClasses];
	}
	
	
}
