package sss.scheduler.objects;

public class Subject implements Comparable<Subject> {


	protected String name;
	protected String code;
	protected boolean homework;
	
	
	/*
	 * Getters
	 */
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param code
	 * @param homework
	 */
	public Subject (String name, String code, boolean homework) {
		this.name = name;
		this.code = code;
		this.homework = homework;
	}
	
	/**
	 * Tells if the subject requires homework or not.
	 * @return boolean
	 */
	public boolean requiresHomework() {
		return homework;
	}

	@Override
	public int compareTo(Subject s) {
		return code.compareTo(s.getCode());
	}
}
