package sss.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Schedule;

public class OutputWriter {

	protected Schedule schedule;
	protected TreeMap<String, ClassInSchool> classes;

	public OutputWriter(Schedule schedule, TreeMap<String, ClassInSchool> classes) {
		this.schedule = schedule;
		this.classes = classes;
	}

	public void writeClassSchedulesToFile() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output/classSchedules.csv", "UTF-8");
			for (Entry<String, ClassInSchool> entry : classes.entrySet()) {
				System.out.println(entry.getKey());
				ClassInSchool classInSchool = entry.getValue();
				writer.print(writeClassSchedule(classInSchool));
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private String writeClassSchedule(ClassInSchool classInSchool) {
		String schedule = classInSchool.getName() + "\n";
		ArrayList<Lesson> lessons = this.schedule.getAllocatedLessons();
		Collections.sort(lessons);
		
		for (Lesson lesson : lessons) {
			if (lesson.isAllocatedTo(classInSchool))
				schedule += lesson.getWeekday().name() + ", " +
							lesson.getHour().getStartTime().getHours() + ":" + lesson.getHour().getStartTime().getMinutes() + "-" + 
							lesson.getHour().getEndTime().getHours() + ":" + lesson.getHour().getEndTime().getMinutes() + ", " +
							lesson.getSubject().getName() + "\n";
		}
		schedule+= "\n";
		
		return schedule;
	}
	
	

}
