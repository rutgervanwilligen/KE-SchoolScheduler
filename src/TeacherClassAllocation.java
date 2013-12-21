import java.util.ArrayList;
import java.util.TreeMap;

public class TeacherClassAllocation {

	// Contains a matrix, mapping teachers to specific classes.
	
	private Teacher[][] matrix;
	private TreeMap<Subject, Integer> subjectMap;
	private TreeMap<ClassInSchool, Integer> classMap;
	
	/**
	 * Constructor. Creates an empty matrix of teachers of dimensions nSubjects x nClasses.
	 * @param nSubjects Number of subjects given.
	 * @param nClasses Number of classes in school.
	 */
	public TeacherClassAllocation (int nSubjects, int nClasses) {
		matrix = new Teacher[nSubjects][nClasses];
		subjectMap = new TreeMap<Subject, Integer>();
		classMap = new TreeMap<ClassInSchool, Integer>();
	}
	
	/**
	 * Allocates a teacher to a subject and a class in school.
	 * @param t The teacher to allocate.
	 * @param s The subject to allocate the teacher to.
	 * @param c The class to allocate the teacher to.
	 */
	public void allocateTeacher(Teacher t, Subject s, ClassInSchool c) {
		matrix[subjectMap.get(s)][classMap.get(c)] = t;
	}
	
	/**
	 * Returns the teacher, given a subject and a class
	 * @param s The subject for which the teacher is returned
	 * @param c The class for which the teacher is returned
	 * @return The teacher object for this allocation.
	 */
	public Teacher getTeacher(Subject s, ClassInSchool c) {
		return matrix[subjectMap.get(s)][classMap.get(c)];
	}
	
	/**
	 * Returns ArrayList containing all classes allocated to a teacher and subject.
	 * @param t The teacher for which the classes are returned.
	 * @param s The subject for which the teacher's classes are returned.
	 * @return ArrayList containing all allocated classes.
	 */
	public ArrayList<ClassInSchool> getClasses(Teacher t, Subject s) {
		ArrayList<ClassInSchool> result = new ArrayList<ClassInSchool>();
		for (ClassInSchool c : classMap.keySet()) {
			if (matrix[subjectMap.get(s)][classMap.get(c)].equals(t)) {
				result.add(c);
			}
		}
		return result;
	}
}
