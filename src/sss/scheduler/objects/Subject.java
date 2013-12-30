package sss.scheduler.objects;

public class Subject {
	
	private String name;
	private String code;
	private boolean homework;
	
	public Subject (String name, String code, boolean homework) {
		this.name = name;
		this.code = code;
		this.homework = homework;
	}
	
	public boolean requiresHomework() {
		return homework;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}
