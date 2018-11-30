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

import org.ILE.course.Course;

public class CoursePage extends JPanel {
	
	private Course thisCourse;
	
	private JLabel course;
	private JButton logoutButton, lessonButton, quizButton;
	
	public CoursePage() {
//		logoutButton = new JButton("Logout");
//		lessonButton = new JButton("Go to lesson");
//		quizButton = new JButton("Go to quiz");
//		
//		add(logoutButton);
//		add(lessonButton);
//		add(quizButton);
//		
//		lessonButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				LessonButtonPressed();
//			}
//		});
//		
//		quizButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				QuizButtonPressed();
//			}
//		});
//		
//		logoutButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				LogoutButtonPressed();
//			}
//		});
	}
	
	public void RebuildCoursePage(Course aCourse) {
		removeAll();
		
		thisCourse = aCourse;
		course = new JLabel(thisCourse.getName());
		add(course);
		logoutButton = new JButton("Logout");
		lessonButton = new JButton("Go to lesson");
		quizButton = new JButton("Go to quiz");
		
		add(logoutButton);
		add(lessonButton);
		add(quizButton);
		
		lessonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LessonButtonPressed();
			}
		});
		
		quizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizButtonPressed();
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutButtonPressed();
			}
		});
	}
	
	public void LessonButtonPressed() {
		MainFrame.GoToLessonPage();
	}
	
	public void QuizButtonPressed() {
		MainFrame.GoToQuizPage();
	}
	
	public void LogoutButtonPressed() {
		MainFrame.GoToLoginPage();
	}
	


}
