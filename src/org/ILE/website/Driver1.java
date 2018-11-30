package org.ILE.website;

import org.ILE.GUI.MainFrame;
import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.user.*;



public class Driver1 {

	public static void main(String[] args) 
	{
		ILE theILE = new ILE();
		
		Student s1 = new Student();
		s1.setName("Chris");
		s1.getAccount().setUserName("Student1");
		s1.getAccount().setPassword("learnlots");
				
		Teacher t1 = new Teacher();
		t1.setName("Bob");
		t1.getAccount().setUserName("Teacher1");
		t1.getAccount().setPassword("teachlots");
				
		Administrator a1 = new Administrator();
		a1.setName("Sally");
		a1.getAccount().setUserName("Admin1");
		a1.getAccount().setPassword("administrator");
		
		theILE.addUser(s1);
		theILE.addUser(t1);
		theILE.addUser(a1);
		
		Question u1 = new Question();
		u1.setText("The answer to this is A.");
		u1.setSolution("A");
		
		//need to make a quiz to add this too
		Badge b1 = new Badge();
		b1.setName("You did it!");
		b1.setRequirement("Complete a quiz");
		b1.setPercentRequired(100);
		
		Quiz q1 = new Quiz();
		q1.addQuestion(u1);
		q1.setBadge(b1);
		
		Video v1 = new Video();
		v1.setName("Video #1");
		v1.setUrl("https://www.ILEVideos.com/Video1");
		
		Lesson l1 = new Lesson();
		l1.setNumber(1);
		l1.setQuiz(q1);
		l1.addVideo(v1);
		
		Course c1 = new Course();
		c1.setName("Course #1");
		c1.addLesson(l1);
		t1.addCourse(c1);
		s1.addCourse(c1);
		theILE.addCourse(c1);
		
		Course c2 = new Course();
		c2.setName("Course #2");
		s1.addCourse(c2);
		theILE.addCourse(c2);
		
		Message m1 = new Message();
		m1.setMessage("Hello world.");
		m1.setFromUser(s1);
		m1.setToUser(t1);
		m1.sendMessage();
		
		Note n1 = new Note();
		n1.setNote("This is a note");
		n1.setLesson(l1);
		s1.addNote(n1);
		
		Issue i1 = new Issue();
		i1.setIssue("Something is wrong");
		ILE.assignIssue(i1);
		
		
		//user input functions
		//s1.reportIssue();
		//theILE.createAccount();
		//theILE.loginScreen();
		
		MainFrame theGUI = new MainFrame(theILE);
		
	}
}

