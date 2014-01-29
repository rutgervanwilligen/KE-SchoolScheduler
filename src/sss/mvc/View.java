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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import sss.scheduler.objects.Schedule;

@SuppressWarnings("serial")
public class View extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	final JFileChooser fileChooser = new JFileChooser();

	private JPanel contentPane;
	private JTextPane consoleTextPane;
	private JTextField teacherInfoField;

	private JButton btnRun, btnStop, btnPrint;
	private JTextField classesInfoField;
	private JTextField teacherClassesInfoField;
	private JTextField classroomInfoField;
	private JTextField hoursInfoField;
	private JTextField subjectInfoField;
	private JTextField subjectHoursInfoField;

	private JProgressBar progressBar;

	private JTextPane textPaneRating;

	/**
	 * Create the frame.
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

		JLabel lblDocenten = new JLabel("Teacher information:");
		lblDocenten.setBounds(42, 39, 194, 15);
		contentPane.add(lblDocenten);

		JLabel label = new JLabel("Classes information:");
		label.setBounds(42, 68, 194, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Classroom info:");
		label_1.setBounds(42, 122, 194, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Teacher-classes info:");
		label_2.setBounds(42, 95, 194, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Subject info:");
		label_3.setBounds(42, 176, 194, 15);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Hours info:");
		label_4.setBounds(42, 149, 194, 15);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Subject-hours info:");
		label_5.setBounds(42, 203, 194, 15);
		contentPane.add(label_5);

		teacherInfoField = new JTextField();
		teacherInfoField.setColumns(10);
		teacherInfoField.setBounds(233, 37, 265, 19);
		contentPane.add(teacherInfoField);

		JButton btnSelectTeacherFile = new JButton("Select file");
		btnSelectTeacherFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(teacherInfoField);
			}
		});
		btnSelectTeacherFile.setBounds(503, 36, 117, 20);
		contentPane.add(btnSelectTeacherFile);
		
		classesInfoField = new JTextField();
		classesInfoField.setColumns(10);
		classesInfoField.setBounds(233, 64, 265, 19);
		contentPane.add(classesInfoField);
		
		JButton btnSelectClassesFile = new JButton("Select file");
		btnSelectClassesFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(classesInfoField);
			}
		});
		btnSelectClassesFile.setBounds(503, 63, 117, 20);
		contentPane.add(btnSelectClassesFile);
		
		teacherClassesInfoField = new JTextField();
		teacherClassesInfoField.setColumns(10);
		teacherClassesInfoField.setBounds(233, 91, 265, 19);
		contentPane.add(teacherClassesInfoField);
		
		JButton btnSelectTeacherClassesInfo = new JButton("Select file");
		btnSelectTeacherClassesInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(teacherClassesInfoField);
			}
		});
		btnSelectTeacherClassesInfo.setBounds(503, 90, 117, 20);
		contentPane.add(btnSelectTeacherClassesInfo);
		
		classroomInfoField = new JTextField();
		classroomInfoField.setColumns(10);
		classroomInfoField.setBounds(233, 118, 265, 19);
		contentPane.add(classroomInfoField);
		
		JButton btnSelectClassroomInfo = new JButton("Select file");
		btnSelectClassroomInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(classroomInfoField);
			}
		});
		btnSelectClassroomInfo.setBounds(503, 117, 117, 20);
		contentPane.add(btnSelectClassroomInfo);
		
		hoursInfoField = new JTextField();
		hoursInfoField.setColumns(10);
		hoursInfoField.setBounds(233, 145, 265, 19);
		contentPane.add(hoursInfoField);
		
		JButton btnSelectHoursInfo = new JButton("Select file");
		btnSelectHoursInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(hoursInfoField);
			}
		});
		btnSelectHoursInfo.setBounds(503, 144, 117, 20);
		contentPane.add(btnSelectHoursInfo);
		
		subjectInfoField = new JTextField();
		subjectInfoField.setColumns(10);
		subjectInfoField.setBounds(233, 172, 265, 19);
		contentPane.add(subjectInfoField);
		
		JButton btnSelectSubjectInfo = new JButton("Select file");
		btnSelectSubjectInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(subjectInfoField);
			}
		});
		btnSelectSubjectInfo.setBounds(503, 171, 117, 20);
		contentPane.add(btnSelectSubjectInfo);
		
		subjectHoursInfoField = new JTextField();
		subjectHoursInfoField.setColumns(10);
		subjectHoursInfoField.setBounds(233, 200, 265, 19);
		contentPane.add(subjectHoursInfoField);
		
		JButton btnSelectSubjectHoursInfo = new JButton("Select file");
		btnSelectSubjectHoursInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile(subjectHoursInfoField);
			}
		});
		btnSelectSubjectHoursInfo.setBounds(503, 199, 117, 20);
		contentPane.add(btnSelectSubjectHoursInfo);
		
		JLabel lblCurrentScheduleRating = new JLabel("Current schedule rating: ");
		lblCurrentScheduleRating.setBounds(582, 299, 184, 15);
		contentPane.add(lblCurrentScheduleRating);
		
		textPaneRating = new JTextPane();
		textPaneRating.setText("-");
		textPaneRating.setBounds(763, 293, 78, 21);
		contentPane.add(textPaneRating);
		
		JLabel lblFillInThe = new JLabel("Fill in the location of each input file, or leave empty to use defaults values.");
		lblFillInThe.setBounds(42, 12, 855, 15);
		contentPane.add(lblFillInThe);
		
		btnPrint = new JButton("Print schedules");
		btnPrint.setBounds(577, 586, 158, 25);
		contentPane.add(btnPrint);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(132, 262, 78, 25);
		contentPane.add(btnStop);
		
		redirectSystemStreams();
	}

	protected void selectFile(JTextField teacherInfoField) {
		if (fileChooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			teacherInfoField.setText(file.getPath());
		}
	}

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

	@Override
	public void update(Observable o, Object arg) {
		Schedule schedule = (Schedule) o;
		
		progressBar.setValue((int) schedule.getProgress());
		textPaneRating.setText(String.valueOf(schedule.getRating()));
	}
	
	private void redirectSystemStreams() {
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

	private void updateTextPane(final String text) {
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
