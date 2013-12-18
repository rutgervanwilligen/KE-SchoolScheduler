package reasoning;

import java.util.ArrayList;
import java.util.Iterator;

import javax.security.auth.Subject;

import jess.Filter;
import jess.JessException;

public class SubjectSelectionReasoner extends Reasoner {
	
	public static final String SUBJECT_REASONER_FILE = "bla.clp";
	
	protected ArrayList<Subject> subjects;
	
	public SubjectSelectionReasoner() {
		this.addRuleFile(SUBJECT_REASONER_FILE);
	}
	
	public void setSubjects(ArrayList<Subject> subjects) throws JessException {
        this.subjects = subjects;
	}
	
	public Subject getMostSuitableSubject() throws JessException {
		Subject result = null;
		
		engine.resetToMark(marker);
		engine.addAll(subjects);
		engine.run();
		
		Iterator generatedSubjects = engine.getObjects(new Filter.ByClass(Subject.class));
		// filter best suitable subject
		
		subjects.remove(result);
		
		return result;
	}
	
}