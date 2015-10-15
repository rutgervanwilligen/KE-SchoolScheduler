package sss.scheduler;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;

public class SubjectClassAllocation {
	
	// Contains a matrix of string vectors denoting needs and lengths of lesson hours for each subject and class.
	private String[][][] matrix;
	private TreeMap<Subject, Integer> subjectMap;
	private TreeMap<ClassInSchool, Integer> classMap;

	private Map<String, Subject> subjects;
	private Map<String, ClassInSchool> classes;
	
	/**
	 * Constructor. Creates an empty matrix of hour counts of dimensions nSubjects x nClasses.
	 * @param nSubjects Number of subjects given.
	 * @param nClasses Number of classes in school.
	 */
	public SubjectClassAllocation (Map<String, Subject> subjects, Map<String, ClassInSchool> classes) {
		matrix = new String[subjects.size()][classes.size()][];
		subjectMap = new TreeMap<Subject, Integer>();
		classMap = new TreeMap<ClassInSchool, Integer>();
		
		this.subjects = subjects;
		this.classes = classes;
		
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
	 * Allocates a number of hours of a subject to a class in school.
	 * @param s The subject to allocate the teacher to.
	 * @param c The class to allocate the teacher to.
	 * @param n The amount of hours to allocate.
	 */
	public void allocateHourNeeds(Subject s, ClassInSchool c, ArrayList<String> n) {
		String[] stringArray = n.toArray(new String[n.size()]);
		matrix[subjectMap.get(s)][classMap.get(c)] = stringArray;
	}
	
	/**
	 * Allocates a number of hours of a subject to a class in school.
	 * @param subjectString The String identifier of the subject to allocate the teacher to.
	 * @param classString The String identifier of the class to allocate the teacher to.
	 * @param n The amount of hours to allocate.
	 */
	public void allocateHourNeeds(String subjectString, String classString, ArrayList<String> n) {
		String[] stringArray = n.toArray(new String[n.size()]);
		Subject s = subjects.get(subjectString);
		ClassInSchool c = classes.get(classString);
		matrix[subjectMap.get(s)][classMap.get(c)] = stringArray;
	}
	
	/**
	 * Returns the amount of hours of a subject for a class
	 * @param s The subject for which the teacher is returned
	 * @param c The class for which the teacher is returned
	 * @return The amount of hours class c needs for subject s.
	 */
	public String[] getHours(Subject s, ClassInSchool c) {
		return matrix[subjectMap.get(s)][classMap.get(c)];
	}
	
	/**
	 * Returns the amount of hours of a subject for a class
	 * @param subjectString The String identifier of the subject for which the teacher is returned
	 * @param classString The String identifier of the class for which the teacher is returned
	 * @return The amount of hours the class needs for the subject.
	 */
	public String[] getHours(String subjectString, String classString) {
		Subject s = subjects.get(subjectString);
		ClassInSchool c = classes.get(classString);			
		return matrix[subjectMap.get(s)][classMap.get(c)];
	}
}
