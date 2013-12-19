

import java.util.Collection;

import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

public class Reasoner {
	
	protected Rete engine;
	protected String filePath;
	protected WorkingMemoryMarker marker;
	
	public void initiateEngine() throws JessException {
		// create rule engine
        engine = new Rete();
        engine.reset();
        
        // load file
		engine.batch(filePath);
		
		// mark
		marker = engine.mark();
	}
	
	public void run() throws JessException {
        engine.run();
    }
	
	protected void addRuleFile(String filePath) {
		this.filePath = filePath;
	}
	
	public void addObjects(Collection objects) throws JessException {
		engine.addAll(objects);
		
		// mark
		marker = engine.mark();
	}

}
