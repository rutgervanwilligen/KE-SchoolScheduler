package sss.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	String[] defaultFiles = { "inputs/docenteninfo.csv",
			"inputs/klasseninfo.csv", "inputs/ureninfo.csv",
			"inputs/vakkeninfo.csv", "inputs/lokaleninfo.csv",
			"inputs/vakkenurenaantallen.csv", "inputs/klassendocenten.csv", };

	private Model model;
	private View view;
	private ActionListener runActionListener;

	private ActionListener stopActionListener;

	private ActionListener printActionListener;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void control() {
		runActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				startScheduling();
			}
		};
		stopActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				stopScheduling();
			}
		};
		printActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				printSchedules();
			}
		};
		view.getRunButton().addActionListener(runActionListener);
		view.getStopButton().addActionListener(stopActionListener);
		view.getPrintButton().addActionListener(printActionListener);
		model.getSchedule().addObserver(view);
	}

	private void startScheduling() {
		if (! model.isRunning()) {
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
	
	private void stopScheduling() {
		model.stopScheduler();
	}
	
	private void printSchedules() {
		model.writeOutput();
	}

}
