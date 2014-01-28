package sss;

import javax.swing.SwingUtilities;

import sss.mvc.Controller;
import sss.mvc.Model;
import sss.mvc.View;

public class Main {

	
	public static void main(String[] args) {         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                                           
                Model model = new Model();
                View view = new View(); 
                view.setVisible(true);
                Controller controller = new Controller(model,view);
                controller.contol();
            }
        });
	}

}
