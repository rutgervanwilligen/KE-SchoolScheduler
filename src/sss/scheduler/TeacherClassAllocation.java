package sss.scheduler;

import java.util.ArrayList;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class TeacherClassAllocation {

	// Contains a matrix, mapping teachers to specific classes.
	
	private Teacher[][] matrix;
	private TreeMap<Subject, Integer> subjectMap;
	private TreeMap<ClassInSchool, Integer> classMap;
	
	private TreeMap<String, Teacher> teachers;
	private TreeMap<String, Subject> subjects;
	private TreeMap<String, ClassInSchool> classes;
	
	/**
	 * Constructor. Creates an empty matrix of teachers of dimensions nSubjects x nClasses.
	 * @param nSubjects Number of subjects given.
	 * @param nClasses Number of classes in school.
	 */
	public TeacherClassAllocation (TreeMap<String, Teacher> teachers, 
			TreeMap<String, Subject> subjects, TreeMap<String, ClassInSchool> classes) {
		
		this.teachers = teachers;
		this.subjects = subjects;
		this.classes = classes;
		
		matrix = new Teacher[subjects.size()][classes.size()];
		subjectMap = new TreeMap<Subject, Integer>();
		classMap = new TreeMap<ClassInSchool, Integer>();
	
		initializeMaps();
	}
		
	private void initializeMaps() {
		int i=0, j=0;
		
		for (Object o : subjects.values().toArray()) {
			Subject s = (Subject) o;
			subjectMap.put(s, i);
			i++;
		}
		
		for (Object o : classes.values().toArray()) {
			ClassInSchool c = (ClassInSchool) o;
			classMap.put(c, j);
			j++;
		}
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
	 * Allocates a teacher to a subject and a class in school.
	 * @param teacherString The String identifier of the teacher to allocate.
	 * @param subjectString The String identifier of the subject to allocate the teacher to.
	 * @param classString The String identifier of the class to allocate the teacher to.
	 */
	public void allocateTeacher(String teacherString, String subjectString, String classString) {
		Teacher t = teachers.get(teacherString);
		Subject s = subjects.get(subjectString);
		ClassInSchool c = classes.get(classString);
		
		allocateTeacher(t, s, c);
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
