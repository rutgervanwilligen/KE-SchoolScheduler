package sss.scheduler.objects;

import java.util.TreeMap;

public class Subject {
	
	private String name;
	private String code;
	private boolean homework;
	private TreeMap<ClassInSchool, Integer> weeklyHours;
	
	public Subject (String name, String code, boolean homework) {
		this.name = name;
		this.code = code;
		this.homework = homework;
	}
	
	public String getName() {
		return this.name;
	}
	
}
