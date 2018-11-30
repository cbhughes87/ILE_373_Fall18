package org.ILE.GUI;

import java.awt.*;
import javax.swing.*;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.user.*;


public class ILEGUI extends JFrame {

	private int currState;
	//0 - login page
	//1 - user page
	//2 - course page
	//3 - lesson page
	//4 - quiz page
	private static User currUser;
	private static Course currCourse;
	private static Lesson currLesson;
	private static Quiz currQuiz;
	
	private JFrame theFrame;
	private LoginPanel login;
	private MyLoginPanel myLogin;
	private CreateAccountPanel createAccount;
	private CoursePage course;
	
	
	private ILE theILE;
	
	
	public ILEGUI(ILE importILE) {
		
		currState = 0;
		
		theILE = importILE;
		
		theFrame = new JFrame("Interactive Learning Environment");
		theFrame.setSize(new Dimension(1000,500));
		//theFrame.setLayout(new GridLayout(2,1));
		
		JPanel pages;
		final String LOGINPAGE = "Login Page";
		final String COURSEPAGE = "Course Page";
		
		JPanel loginCard = new MyLoginPanel();
		JPanel courseCard = new CoursePage();
		
		pages = new JPanel(new CardLayout());
		pages.add(loginCard, LOGINPAGE);
		pages.add(courseCard, COURSEPAGE);
		
		login = new LoginPanel();
		myLogin = new MyLoginPanel();
		course = new CoursePage();
		
		createAccount = new CreateAccountPanel();
		
		theFrame.add(myLogin);
		
		theFrame.setVisible(true);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		while(true) {
//		
//			switch(currState) {
//			
//				case 0: 
//					//theFrame.removeAll();
//					theFrame.add(myLogin);
//					
//				case 1: 
//					//theFrame.removeAll();
//					theFrame.add(course);
//				default: 
//			}
//			
//			theFrame.setVisible(true);
//			
//		}
		
		//theFrame.add(login);
		//theFrame.add(createAccount);
		

		
	}
}
