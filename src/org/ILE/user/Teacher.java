package org.ILE.user;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.website.*;

public class Teacher extends SchoolUser {

	//attributes
	//private ArrayList<Course> courseList;
	//private ArrayList<Message> messageList;
	
	//constructor
	public Teacher() {
		//courseList = new ArrayList<Course>();
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
//
//	public ArrayList<Message> getMessageList() {
//		return messageList;
//	}
//	
//	public void setMessageList(ArrayList<Message> aMessageList) {
//		messageList = aMessageList;
//	}
//	
//	//methods
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
	
	//methods
	public void addCourse(Course aCourse) {
		this.getCourseList().add(aCourse);
		aCourse.setTeacher(this);
		return;
	}
	
	public void removeCourse(Course aCourse) {
		this.getCourseList().remove(aCourse);
		return;
	}
	
	
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
									"3 - View Messages\n" + 
									"4 - Create Course\n" +
									"0 - Logout");
				
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
					myMessages(input);
					break;
				
				case 4:
					createCourse(input);
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
		
		return;
		
	}
	

	public void createCourse(Scanner input) {
		
		System.out.println("Enter the name of the course: ");
		
		String courseName = input.next();
			
		System.out.println("Creating course " + courseName + ". Enter 1 to continue or 0 to exit. ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
			
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > 1) {
				System.out.println("Enter a valid input");
			}
			
			else {
				validInput = true;
			}
		
		} //while(!validInput)
		
		if(optionInt == 0) {
			System.out.println("Canceling...");
			return;
		}
		else {
		
			Course newCourse = new Course();
			
			newCourse.setName(courseName);

			addCourse(newCourse);
			
			ILE.getCourseList().add(newCourse);
		}
		return;
	}
	
	
}
