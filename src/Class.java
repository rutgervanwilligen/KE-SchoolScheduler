import java.util.ArrayList;


public abstract class Class {

	protected ArrayList<Student> studentList;
	
	public boolean addStudent(Student student) {
		return studentList.add(student);
	}
}
