

import java.util.ArrayList;
import java.util.Iterator;

import jess.Filter;
import jess.JessException;

public class LessonReasoner extends Reasoner {
	
	public static final String SUBJECT_REASONER_FILE = "lesson-selection-model.clp";
	
	protected ArrayList<Lesson> lessons;
	
	public LessonReasoner() {
		this.addRuleFile(SUBJECT_REASONER_FILE);
	}
	
	public void setLessons(ArrayList<Lesson> lessons) throws JessException {
        this.lessons = lessons;
	}
	
	public Lesson getMostSuitableLesson() throws JessException {
		Lesson result = null;
		
		engine.resetToMark(marker);
		engine.addAll(lessons);
		engine.run();
		
		Iterator generatedSubjects = engine.getObjects(new Filter.ByClass(Subject.class));
		// filter best suitable subject
		
		lessons.remove(result);
		
		return result;
	}
	
}