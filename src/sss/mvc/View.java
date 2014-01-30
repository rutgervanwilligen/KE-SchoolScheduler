package sss.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import sss.scheduler.objects.Schedule;

public class View extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	final JFileChooser fileChooser = new JFileChooser();

	private JPanel contentPane;
	private JButton btnRun, btnStop, btnPrint;
	private JTextField teacherInfoField, classesInfoField, teacherClassesInfoField, classroomInfoField, hoursInfoField, subjectInfoField, subjectHoursInfoField;
	private JTextPane consoleTextPane, textPaneRating, textPanePenalties, textPaneTotalLessons, textPaneUnallocated, textPaneUnallocatable;
	private JProgressBar progressBar;
	
	/*
	 * Getters
	 */
	public JButton getRunButton() {
		return btnRun;
	}

	public JButton getStopButton() {
		return btnStop;
	}

	public JButton getPrintButton() {
		return btnPrint;
	}
	
	public String[] getFilePaths() {
		String[] result = {
				teacherInfoField.getText(),
				classesInfoField.getText(),
	        	hoursInfoField.getText(),
	        	subjectInfoField.getText(),
	        	classroomInfoField.getText(),
	        	subjectHoursInfoField.getText(),
	        	teacherClassesInfoField.getText(),
	        };
		
		return result;
	}


	/**
	 * Create the frame with all its constents.
	 */
	public View() {
		setTitle("School Scheduling System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRun = new JButton("Run");
		btnRun.setBounds(42, 262, 78, 25);
		contentPane.add(btnRun);

		JButton btnSelectTeacherFile = new JButton("Select file");
		btnSelectTeacherFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(teacherInfoField);
			}
		});
		btnSelectTeacherFile.setBounds(503, 36, 117, 20);
		contentPane.add(btnSelectTeacherFile);
		
		JButton btnSelectClassesFile = new JButton("Select file");
		btnSelectClassesFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(classesInfoField);
			}
		});
		btnSelectClassesFile.setBounds(503, 63, 117, 20);
		contentPane.add(btnSelectClassesFile);
		
		JButton btnSelectTeacherClassesInfo = new JButton("Select file");
		btnSelectTeacherClassesInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(teacherClassesInfoField);
			}
		});
		btnSelectTeacherClassesInfo.setBounds(503, 90, 117, 20);
		contentPane.add(btnSelectTeacherClassesInfo);
		
		JButton btnSelectClassroomInfo = new JButton("Select file");
		btnSelectClassroomInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(classroomInfoField);
			}
		});
		btnSelectClassroomInfo.setBounds(503, 117, 117, 20);
		contentPane.add(btnSelectClassroomInfo);
		
		JButton btnSelectHoursInfo = new JButton("Select file");
		btnSelectHoursInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(hoursInfoField);
			}
		});
		btnSelectHoursInfo.setBounds(503, 144, 117, 20);
		contentPane.add(btnSelectHoursInfo);
		
		JButton btnSelectSubjectInfo = new JButton("Select file");
		btnSelectSubjectInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(subjectInfoField);
			}
		});
		btnSelectSubjectInfo.setBounds(503, 171, 117, 20);
		contentPane.add(btnSelectSubjectInfo);
		
		JButton btnSelectSubjectHoursInfo = new JButton("Select file");
		btnSelectSubjectHoursInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(subjectHoursInfoField);
			}
		});
		btnSelectSubjectHoursInfo.setBounds(503, 199, 117, 20);
		contentPane.add(btnSelectSubjectHoursInfo);

		progressBar = new JProgressBar();
		progressBar.setBounds(222, 262, 343, 25);
		contentPane.add(progressBar);
		JScrollPane scroll = new JScrollPane();
		scroll.getVerticalScrollBar().addAdjustmentListener(
				new AdjustmentListener() {
					public void adjustmentValueChanged(AdjustmentEvent e) {
						consoleTextPane.select(consoleTextPane.getCaretPosition()*consoleTextPane.getFont().getSize(), 0);
					}
				});
		scroll.setBounds(42, 299, 523, 312);
		contentPane.add(scroll);
		
		consoleTextPane = new JTextPane();
		scroll.setViewportView(consoleTextPane);

		JLabel lblTeacherFile = new JLabel("Teacher information:");
		lblTeacherFile.setBounds(42, 39, 194, 15);
		contentPane.add(lblTeacherFile);

		JLabel lblClassesInformation = new JLabel("Classes information:");
		lblClassesInformation.setBounds(42, 68, 194, 15);
		contentPane.add(lblClassesInformation);

		JLabel lblClassroomInformation = new JLabel("Classroom info:");
		lblClassroomInformation.setBounds(42, 122, 194, 15);
		contentPane.add(lblClassroomInformation);

		JLabel lblTeacherClassesInfo = new JLabel("Teacher-classes info:");
		lblTeacherClassesInfo.setBounds(42, 95, 194, 15);
		contentPane.add(lblTeacherClassesInfo);

		JLabel lblSubjectInfo = new JLabel("Subject info:");
		lblSubjectInfo.setBounds(42, 176, 194, 15);
		contentPane.add(lblSubjectInfo);

		JLabel lblHoursInfo = new JLabel("Hours info:");
		lblHoursInfo.setBounds(42, 149, 194, 15);
		contentPane.add(lblHoursInfo);

		JLabel lblSubjectHoursInfo = new JLabel("Subject-hours info:");
		lblSubjectHoursInfo.setBounds(42, 203, 194, 15);
		contentPane.add(lblSubjectHoursInfo);
		
		JLabel lblNrOfPenalties = new JLabel("Number of penalties:");
		lblNrOfPenalties.setBounds(577, 454, 184, 15);
		contentPane.add(lblNrOfPenalties);
		
		JLabel lblNrOfLessons = new JLabel("Total number of lessons:");
		lblNrOfLessons.setBounds(577, 264, 184, 15);
		contentPane.add(lblNrOfLessons);
		
		JLabel lblUnallocatedLessons = new JLabel("Unallocated lessons:");
		lblUnallocatedLessons.setBounds(577, 291, 184, 15);
		contentPane.add(lblUnallocatedLessons);
		
		JLabel lblUnallocatableLessons = new JLabel("Unallocatable lessons:");
		lblUnallocatableLessons.setBounds(577, 319, 184, 15);
		contentPane.add(lblUnallocatableLessons);
		
		JLabel lblCurrentScheduleRating = new JLabel("Current schedule rating: ");
		lblCurrentScheduleRating.setBounds(577, 427, 184, 15);
		contentPane.add(lblCurrentScheduleRating);
		
		JLabel lblFillInThe = new JLabel("Fill in the location of each input file, or leave empty to use defaults values.");
		lblFillInThe.setBounds(42, 12, 855, 15);
		contentPane.add(lblFillInThe);

		teacherInfoField = new JTextField();
		teacherInfoField.setColumns(10);
		teacherInfoField.setBounds(233, 37, 265, 19);
		contentPane.add(teacherInfoField);
		
		classesInfoField = new JTextField();
		classesInfoField.setColumns(10);
		classesInfoField.setBounds(233, 64, 265, 19);
		contentPane.add(classesInfoField);
		
		teacherClassesInfoField = new JTextField();
		teacherClassesInfoField.setColumns(10);
		teacherClassesInfoField.setBounds(233, 91, 265, 19);
		contentPane.add(teacherClassesInfoField);
		
		classroomInfoField = new JTextField();
		classroomInfoField.setColumns(10);
		classroomInfoField.setBounds(233, 118, 265, 19);
		contentPane.add(classroomInfoField);
		
		hoursInfoField = new JTextField();
		hoursInfoField.setColumns(10);
		hoursInfoField.setBounds(233, 145, 265, 19);
		contentPane.add(hoursInfoField);
		
		subjectInfoField = new JTextField();
		subjectInfoField.setColumns(10);
		subjectInfoField.setBounds(233, 172, 265, 19);
		contentPane.add(subjectInfoField);
		
		subjectHoursInfoField = new JTextField();
		subjectHoursInfoField.setColumns(10);
		subjectHoursInfoField.setBounds(233, 200, 265, 19);
		contentPane.add(subjectHoursInfoField);
		
		textPaneRating = new JTextPane();
		textPaneRating.setText("-");
		textPaneRating.setBounds(757, 421, 78, 21);
		contentPane.add(textPaneRating);
		
		btnPrint = new JButton("Print schedules");
		btnPrint.setBounds(577, 586, 158, 25);
		contentPane.add(btnPrint);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(132, 262, 78, 25);
		contentPane.add(btnStop);
		
		textPanePenalties = new JTextPane();
		textPanePenalties.setText("-");
		textPanePenalties.setBounds(757, 448, 78, 21);
		contentPane.add(textPanePenalties);
		
		textPaneUnallocated = new JTextPane();
		textPaneUnallocated.setText("-");
		textPaneUnallocated.setBounds(757, 285, 78, 21);
		contentPane.add(textPaneUnallocated);
		
		textPaneTotalLessons = new JTextPane();
		textPaneTotalLessons.setText("-");
		textPaneTotalLessons.setBounds(757, 258, 78, 21);
		contentPane.add(textPaneTotalLessons);
		
		textPaneUnallocatable = new JTextPane();
		textPaneUnallocatable.setText("-");
		textPaneUnallocatable.setBounds(757, 313, 78, 21);
		contentPane.add(textPaneUnallocatable);
		
		redirectSystemStreams();
	}

	/**
	 * Call fileChooser to select a file and return the value to the JTextField.
	 * @param teacherInfoField
	 */
	protected void selectFile(JTextField teacherInfoField) {
		if (fileChooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			teacherInfoField.setText(file.getPath());
		}
	}

	/**
	 * Update all values in the text pane using the Schedule object.
	 */
	@Override
	public void update(Observable o, Object arg) {
		Schedule schedule = (Schedule) o;
		
		progressBar.setValue((int) schedule.getProgress());
		textPaneRating.setText(String.valueOf(schedule.getRating()));
		textPanePenalties.setText(String.valueOf(schedule.getNumberOfPenalties()));
		textPaneTotalLessons.setText(String.valueOf(schedule.getTotalNumberOfLessons()));
		textPaneUnallocatable.setText(String.valueOf(schedule.getUnallocatableLessons().size()));
		textPaneUnallocated.setText(String.valueOf(schedule.getUnallocatedLessons().size()));
	}
	
	/**
	 * Redirects the System.out output stream to the console text pane.
	 */
	protected void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(final int b) throws IOException {
				updateTextPane(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				updateTextPane(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				write(b, 0, b.length);
			}
		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	/**
	 * Updates the console text pane.
	 * @param text
	 */
	protected void updateTextPane(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Document doc = consoleTextPane.getDocument();
				try {
					doc.insertString(doc.getLength(), text, null);
				} catch (BadLocationException e) {
					throw new RuntimeException(e);
				}
				consoleTextPane.setCaretPosition(doc.getLength() - 1);
			}
		});
	}
}
