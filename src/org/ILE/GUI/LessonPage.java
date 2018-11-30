package org.ILE.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LessonPage extends JPanel {
	
	private JLabel lesson;
	private JButton logoutButton, courseButton;
	
	public LessonPage() {
		lesson = new JLabel("This is the lesson page");
		logoutButton = new JButton("Logout");
		courseButton = new JButton("Return to course");
		
		add(lesson);
		add(logoutButton);
		add(courseButton);
		
		courseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseButtonPressed();
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutButtonPressed();
			}
		});
	}
	
	public void CourseButtonPressed() {
		MainFrame.GoToCoursePage();
	}
	
	public void LogoutButtonPressed() {
		MainFrame.GoToLoginPage();
	}
	


}
