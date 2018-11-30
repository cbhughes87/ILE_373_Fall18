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

public class QuizPage extends JPanel {
	
	private JLabel quiz;
	private JButton logoutButton, lessonButton;
	
	public QuizPage() {
		quiz = new JLabel("This is the quiz page");
		logoutButton = new JButton("Logout");
		lessonButton = new JButton("Go to course");
		
		add(quiz);
		add(logoutButton);
		add(lessonButton);
		
		lessonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LessonButtonPressed();
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutButtonPressed();
			}
		});
	}
	
	public void LessonButtonPressed() {
		MainFrame.GoToCoursePage();
	}
	
	public void LogoutButtonPressed() {
		MainFrame.GoToLoginPage();
	}
	


}

