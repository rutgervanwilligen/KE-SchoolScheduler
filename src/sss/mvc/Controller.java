package sss.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	String[] defaultFiles = {
			"inputs/docenteninfo.csv",
        	"inputs/klasseninfo.csv",
        	"inputs/ureninfo.csv",
        	"inputs/vakkeninfo.csv",
        	"inputs/lokaleninfo.csv",
        	"inputs/vakkenurenaantallen.csv",
        	"inputs/klassendocenten.csv",
        };

    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }
    
    public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnAndLabel();
              }
        };
        model.getSchedule().addObserver(view);
        view.getRunButton().addActionListener(actionListener);   
    }
    
    private void linkBtnAndLabel(){
    	String[] files = view.getFilePaths();
    	for (int i = 0; i < files.length; i++) {
			if (files[i].length() == 0) {
				files[i] = defaultFiles[i];
			}
		}
        model.readInputFiles(files);
        
        Thread thread = new Thread(model);
        thread.start();
    } 

}
