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

import org.ILE.user.*;

public class MyLoginPanel extends JPanel {
	
	private JTextField user;
	private JTextField pass;
	private JLabel userLabel, passLabel;
	private JButton loginButton;

	private JTextField createAccountuser, createAccountName;
	private JTextField createAccountpass;
	private JLabel createAccountuserLabel, createAccountpassLabel, createAccountNameLabel;
	private JButton createTeacherAccountButton, createStudentAccountButton;
	
	public MyLoginPanel() {}
	
	public void RebuildLoginPage() {
		removeAll();
		
		JPanel container = new JPanel();
		//container.setLayout(new BoxLayout(container,BoxLayout.X_AXIS));
		
		JPanel loginPanel = new JPanel();
		JPanel createAccountPanel = new JPanel(); 
		
		int loginTopBottom = 250;
		int loginTextSize = 20;
		Font loginFont = new Font(null, Font.PLAIN, loginTextSize);
		user = new JTextField(10);
		pass = new JPasswordField(10);
		userLabel = new JLabel("Username");
		passLabel = new JLabel("Password");
		loginButton = new JButton("Log In");
		
		user.setMaximumSize(new Dimension(120, 20));
		user.setFont(loginFont);
		
		pass.setMaximumSize(new Dimension(120, 20));
		//pass.setEchoChar('*');
		pass.setFont(loginFont);
		
		userLabel.setFont(loginFont);
		
		passLabel.setFont(loginFont);
		
		loginButton.setFont(loginFont);
		
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setPreferredSize(new Dimension(500, 500));
		//add(Box.createRigidArea(new Dimension(100, loginTopBottom)));
		loginPanel.add(userLabel);
		loginPanel.add(user);
		//add(Box.createVerticalGlue());
		loginPanel.add(passLabel);
		loginPanel.add(pass);
		//add(Box.createVerticalGlue());
		loginPanel.add(loginButton);
		//add(Box.createRigidArea(new Dimension(100, loginTopBottom)));
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginButtonPressed();
			}
		});
		
		int createAccountTopBottom = 250;
		int createAccountSize = 20;
		createAccountuser = new JTextField(10);
		createAccountpass = new JTextField(10);
		createAccountName = new JTextField(10);
		createAccountuserLabel = new JLabel("Username");
		createAccountpassLabel = new JLabel("Password");
		createAccountNameLabel = new JLabel("Name");
		createTeacherAccountButton = new JButton("Create Teacher Account");
		createStudentAccountButton = new JButton("Create Student Account");
		
		createAccountuser.setMaximumSize(new Dimension(120, 20));
		createAccountuser.setFont(loginFont);
		
		createAccountName.setMaximumSize(new Dimension(120, 20));
		createAccountName.setFont(loginFont);
		
		createAccountpass.setMaximumSize(new Dimension(120, 20));
		//createAccountpass.setEchoChar('*');
		createAccountpass.setFont(loginFont);
		
		createAccountuserLabel.setFont(loginFont);
		
		createAccountpassLabel.setFont(loginFont);
		
		createAccountNameLabel.setFont(loginFont);
		
		createTeacherAccountButton.setFont(loginFont);
		createStudentAccountButton.setFont(loginFont);
		
		createAccountPanel.setLayout(new BoxLayout(createAccountPanel, BoxLayout.Y_AXIS));
		createAccountPanel.setPreferredSize(new Dimension(500, 500));
		//add(Box.createRigidArea(new Dimension(100, loginTopBottom)));
		createAccountPanel.add(createAccountNameLabel);
		createAccountPanel.add(createAccountName);
		createAccountPanel.add(createAccountuserLabel);
		createAccountPanel.add(createAccountuser);
		//add(Box.createVerticalGlue());
		createAccountPanel.add(createAccountpassLabel);
		createAccountPanel.add(createAccountpass);
		//add(Box.createVerticalGlue());
		createAccountPanel.add(createStudentAccountButton);
		createAccountPanel.add(createTeacherAccountButton);
		//add(Box.createRigidArea(new Dimension(100, loginTopBottom)));
		
		createStudentAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateStudentAccountButtonPressed();
			}
		});
		
		createTeacherAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTeacherAccountButtonPressed();
			}
		});
		
		container.add(loginPanel);
		//container.add(Box.createRigidArea(new Dimension(100, 100)));
		container.add(createAccountPanel);
		
		add(container);
	}
	
	public void LoginButtonPressed() {
		
		String username = user.getText();
		String password = pass.getText();
		User loginUser = MainFrame.getILE().validateUsernameAndPassWord(username, password);
		if(loginUser != null) {
			MainFrame.setCurrUser(loginUser);
			MainFrame.GoToUserPage();
		}
		else {
			JOptionPane.showMessageDialog(null, "Username name and password do not match", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void CreateStudentAccountButtonPressed() {
		
		String name = createAccountName.getText();
		String username = createAccountuser.getText();
		String password = createAccountpass.getText();
		
		if(!(MainFrame.getILE().validateNewUserName(username))) {
			JOptionPane.showMessageDialog(null, "Username name and password do not match", "Login Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!(MainFrame.getILE().validateNewPassword(password))) {
			JOptionPane.showMessageDialog(null, "Username name and password do not match", "Login Error", JOptionPane.ERROR_MESSAGE);	
			return;
		}
		
		Student newStudent = new Student();
		newStudent.setName(name);
		newStudent.getAccount().setUserName(username);
		newStudent.getAccount().setPassword(password);
		
		MainFrame.getILE().addUser(newStudent);
		
		MainFrame.setCurrUser(newStudent);
		MainFrame.GoToUserPage();
	}
	
	public void CreateTeacherAccountButtonPressed() {
		
		String name = createAccountName.getText();
		String username = createAccountuser.getText();
		String password = createAccountpass.getText();
		
		if(!(MainFrame.getILE().validateNewUserName(username))) {
			JOptionPane.showMessageDialog(null, "Username name already taken", "Login Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!(MainFrame.getILE().validateNewPassword(password))) {
			JOptionPane.showMessageDialog(null, "Password not sufficient", "Login Error", JOptionPane.ERROR_MESSAGE);	
			return;
		}
		
		Teacher newTeacher = new Teacher();
		newTeacher.setName(name);
		newTeacher.getAccount().setUserName(username);
		newTeacher.getAccount().setPassword(password);
		
		MainFrame.getILE().addUser(newTeacher);
		
		MainFrame.setCurrUser(newTeacher);
		MainFrame.GoToUserPage();
	}
	
	
	
}
