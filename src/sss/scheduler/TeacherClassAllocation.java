package sss.scheduler;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Teacher;

public class TeacherClassAllocation {

	// Contains a matrix, mapping teachers to specific classes.
	
	private Teacher[][] matrix;
	private TreeMap<Subject, Integer> subjectMap;
	private TreeMap<ClassInSchool, Integer> classMap;
	
	public TeacherClassAllocation (int nSubjects, int nClasses) {
		matrix = new Teacher[nSubjects][nClasses];
		subjectMap = new TreeMap<Subject, Integer>();
		classMap = new TreeMap<ClassInSchool, Integer>();
	}
	
	public void allocateTeacher(Teacher t, Subject s, ClassInSchool c) {
		matrix[subjectMap.get(s)][classMap.get(c)] = t;
	}
	
	public Teacher getTeacher(Subject s, ClassInSchool c) {
		return matrix[subjectMap.get(s)][classMap.get(c)];
	}
}
