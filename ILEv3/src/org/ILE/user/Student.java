package org.ILE.user;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.website.*;

public class Student extends SchoolUser {
	
	//attributes
	//private ArrayList<Course> courseList;
	private ArrayList<Badge> badgeList;
	private ArrayList<Note> notebook;
	//private ArrayList<Message> messageList;
	
	//constructor
	public Student() {
		//courseList = new ArrayList<Course>();
		badgeList = new ArrayList<Badge>();
		notebook = new ArrayList<Note>();
		//messageList = new ArrayList<Message>();
	}
	
	//getters and setters
//	public ArrayList<Course> getCourseList() {
//		return courseList;
//	}
//	
//	public void setCourseList(ArrayList<Course> aCourseList) {
//		courseList = aCourseList;
//	}
	
	public ArrayList<Badge> getBadgeList() {
		return badgeList;
	}
	
	public void setBadgeList(ArrayList<Badge> aBadgeList) {
		badgeList = aBadgeList;
	}
	
	public ArrayList<Note> getNotebook() {
		return notebook;
	}
	
	public void setNotebook(ArrayList<Note> aNotebook) {
		notebook = aNotebook;
	}
	
//	public ArrayList<Message> getMessageList() {
//		return messageList;
//	}
//	
//	public void setMessageList(ArrayList<Message> aMessageList) {
//		messageList = aMessageList;
//	}
	
	//methods
	public void addBadge(Badge aBadge) {
		badgeList.add(aBadge);		
		return;
	}
	
	public void addNote(Note aNote) {
		notebook.add(aNote);
		return;
	}
	
	//methods
	public void addCourse(Course aCourse) {
		this.getCourseList().add(aCourse);
		aCourse.addStudent(this);
		return;
	}
	
	public void removeCourse(Course aCourse) {
		this.getCourseList().remove(aCourse);
		aCourse.removeStudent(this);
		return;
	}
	
//	public void addCourse(Course aCourse) {
//		courseList.add(aCourse);
//		return;
//	}
//	
//	public void removeCourse(Course aCourse) {
//		courseList.remove(aCourse);
//		return;
//	}
//	
//	public void addMessage(Message aMessage) {
//		messageList.add(aMessage);
//		return;
//	}
//	
//	public void removeMessage(Message aMessage) {
//		messageList.remove(aMessage);
//		return;
//	}
	
	
	//Command User Interface
	public void userHomePage(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		
		Boolean continueLoop = true;
		
		int optionInt = 0;
		
		while(continueLoop) {
			
			Boolean validInput = false;
			
			while(!validInput) {
			
				System.out.println(this.getAccount().getUserName() + "'s Homepage\n" + 
									"1 - View All Courses\n" + 
									"2 - View My Courses\n" +
									"3 - View Badges\n" + 
									"4 - View Messages\n" +
									"0 - Logout\n" +
									"Enter an option: ");
				
				optionInt = input.nextInt();
				
				if(optionInt < 0 || optionInt > 4) {
					System.out.println("Enter a valid input");
				}
				
				else {
					validInput = true;
				}
			
			} //while(!validInput)
			
			//input.close();
			
			switch(optionInt) {
				
				case 0:
					logout();
					continueLoop = false;
					break;
				
				case 1:
					allCourses(input);
					break;
					
				case 2:
					myCourses(input);
					break;
					
				case 3:
					myBadges(input);
					break;
				
				case 4:
					myMessages(input);
					break;
					
				default:
					System.out.println("Enter a valid option.");
					break;
			}
		
		} //while(continueLoop)
		
		return;
	}
	
	public void logout() {
		
	}
	
	public void allCourses(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < ILE.getCourseList().size(); i++) {
			
			System.out.println((i + 1) + " - " + ILE.getCourseList().get(i).getName());
		}
		
		System.out.println("Enter the class number to go to class page or 0 to return to your homepage: ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
		
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > ILE.getCourseList().size() + 1) {
				System.out.println("Enter a valid input");
			}
			
			else {
				validInput = true;
			}
		
		} //while(!validInput)
		
		//input.close();
		
		if(optionInt == 0) {
			return;
		}
		else {
			ILE.getCourseList().get(optionInt - 1).coursePage(input);
		}
		
		return;
	}
	
	public void myCourses(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < this.getCourseList().size(); i++) {
			
			System.out.println((i + 1) + " - " + this.getCourseList().get(i).getName());
		}
		
		System.out.println("Enter the class number to go to class page or 0 to return to your homepage: ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
		
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > this.getCourseList().size() + 1) {
				System.out.println("Enter a valid input");
			}
			
			else {
				validInput = true;
			}
		
		} //while(!validInput)
		
		//input.close();
		
		if(optionInt == 0) {
			return;
		}
		else {
			this.getCourseList().get(optionInt - 1).coursePage(input);
		}
		
		return;
		
	}
	
	public void myBadges(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < badgeList.size(); i++) {
			
			System.out.println((i + 1) + " - " + badgeList.get(i).getName());
		}
		
		System.out.println("Enter the badge number to see badge details or 0 to return to your homepage: ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
		
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > badgeList.size() + 1) {
				System.out.println("Enter a valid input");
			}
			
			else {
				validInput = true;
			}
		
		} //while(!validInput)
		
		//input.close();
		
		if(optionInt == 0) {
			return;
		}
		else {
			System.out.println(badgeList.get(optionInt - 1).getRequirements());
		}
		
		return;
			
	}
	
	public void myMessages(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < this.getMessageList().size(); i++) {
			
			System.out.println((i + 1) + " - " + this.getMessageList().get(i).getMessage());
		}
		
		System.out.println("Enter the message number to respond or 0 to return to your homepage: ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
		
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > this.getMessageList().size() + 1) {
				System.out.println("Enter a valid input");
			}
			
			else {
				validInput = true;
			}
		
		} //while(!validInput)
		
		//input.close();
		
		if(optionInt == 0) {
			return;
		}
		else {
			this.getMessageList().get(optionInt - 1).sendMessage();
		}		
	}
}
