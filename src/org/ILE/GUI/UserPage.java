package org.ILE.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.ILE.user.*;

public class UserPage extends JPanel {
	
	private JLabel user;
	private JButton logoutButton, courseButton1, courseButton2;
	//private ArrayList<JButton> courseButtonList;
	
	public UserPage() {
		//courseButtonList = new ArrayList<JButton>();
//		user = new JLabel("This is the user page");
//		logoutButton = new JButton("Logout");
//		courseButton1 = new JButton(MainFrame.getILE().getCourseList().get(0).getName());
//		courseButton2 = new JButton(MainFrame.getILE().getCourseList().get(1).getName());
//		
//		add(user);
//		add(logoutButton);
//		add(courseButton1);
//		add(courseButton2);
//		
//		courseButton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CourseButtonPressed(e);
//			}
//		});
//		
//		courseButton2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CourseButtonPressed(e);
//			}
//		});
//		
//		logoutButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				LogoutButtonPressed();
//			}
//		});
	}
	
	public void RebuildUserPage(User aUser) {
		removeAll();
		
		ArrayList<JButton> courseButtonList = new ArrayList<JButton>();
		
		user = new JLabel(aUser.getName() + "'s Home Page");
		logoutButton = new JButton("Logout");
		
		add(user);
		add(logoutButton);
		
		boolean userType = SchoolUser.class.isAssignableFrom(aUser.getClass());
		
		if(userType) { //user is a Teacher or Student
			SchoolUser aSchoolUser = (SchoolUser)aUser;
			for (int i = 0; i < aSchoolUser.getCourseList().size(); i++) {
				JButton newButton = new JButton(aSchoolUser.getCourseList().get(i).getName());
				courseButtonList.add(newButton);
			}					

			for(int i = 0; i < courseButtonList.size(); i++) {
				add(courseButtonList.get(i));
				courseButtonList.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CourseButtonPressed(e);
					}
				});
			}
		}
		
		else { //user is an Administrator
			
		}
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutButtonPressed();
			}
		});
	
	}
	
	public void CourseButtonPressed(ActionEvent e) {
		JButton theButton = (JButton)e.getSource();
		String buttonName = theButton.getText();
		MainFrame.setCurrCourse(buttonName);
		MainFrame.GoToCoursePage();
	}
	
	public void LogoutButtonPressed() {
		MainFrame.GoToLoginPage();
	}
	


}
