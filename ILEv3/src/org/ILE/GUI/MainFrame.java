package org.ILE.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.user.*;


public class MainFrame extends JFrame {

	private static User currUser;
	private static Course currCourse;
	private static Lesson currLesson;
	private static Quiz currQuiz;
	
	private JFrame theFrame;
	private LoginPanel login;
	private MyLoginPanel myLogin;
	private CreateAccountPanel createAccount;
	private CoursePage course;
	
	private JButton next;
	private static JPanel pages;
	
	private static ILE theILE;
	
	private static MyLoginPanel loginCard;
	private static CoursePage courseCard;
	private static UserPage userCard;
	private static LessonPage lessonCard;
	private static QuizPage quizCard;
	
	final static String LOGINPAGE = "Login Page";
	final static String COURSEPAGE = "Course Page";
	final static String USERPAGE = "User Home Page";
	final static String LESSONPAGE = "Lesson Page";
	final static String QUIZPAGE = "Quiz Page";
	
	public MainFrame(ILE importILE) {
		
		theILE = importILE;
		currUser = theILE.getUserList().get(0);
		
		theFrame = new JFrame("Interactive Learning Environment");
		theFrame.setSize(new Dimension(1000,500));
		theFrame.setLayout(new GridLayout(2,1));
		
		loginCard = new MyLoginPanel();
		courseCard = new CoursePage();
		userCard = new UserPage();
		lessonCard = new LessonPage();
		quizCard = new QuizPage();
		
		pages = new JPanel(new CardLayout());
		pages.add(loginCard, LOGINPAGE);
		pages.add(courseCard, COURSEPAGE);
		pages.add(userCard, USERPAGE);
		pages.add(lessonCard, LESSONPAGE);
		pages.add(quizCard, QUIZPAGE);
		
		//add(pages);
		
//		CardLayout cl = (CardLayout)(pages.getLayout());
//		cl.show(pages, LOGINPAGE);
	    
		theFrame.add(pages);
		
		GoToLoginPage();
		
//		next = new JButton("Next Page");
//		next.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				NextButtonPressed();
//			}
//		});
//		
//		theFrame.add(next);
//		
		
		theFrame.setVisible(true);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static ILE getILE() {
		return theILE;
	}
	
	public static User getCurrUser() {
		return currUser;
	}
	
	public static void setCurrUser(User aUser) {
		currUser = aUser;
	}
	
	public static Course getCurrCourse() {
		return currCourse;
	}
	
	public static void setCurrCourse(String courseName) {
				
		for (int i = 0; i < theILE.getCourseList().size(); i++) {
			if(theILE.getCourseList().get(i).getName().equals(courseName)) {
				currCourse = theILE.getCourseList().get(i);
				return;
			}
		}
	}
	
	public void NextButtonPressed() {
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, COURSEPAGE);
	}
	
	public static void GoToNext() {
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, COURSEPAGE);
	}
	
	public static void GoToLoginPage() {
		loginCard.RebuildLoginPage();
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, LOGINPAGE);
	}
	
	public static void GoToUserPage() {
		userCard.RebuildUserPage(currUser);
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, USERPAGE);
	}
	
	public static void GoToCoursePage() {
		courseCard.RebuildCoursePage(currCourse);
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, COURSEPAGE);
	}
	
	public static void GoToLessonPage() {
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, LESSONPAGE);
	}
	
	public static void GoToQuizPage() {
		CardLayout cl = (CardLayout)(pages.getLayout());
		cl.show(pages, QUIZPAGE);
	}
	
}
