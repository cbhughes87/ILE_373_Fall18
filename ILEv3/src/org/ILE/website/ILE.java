package org.ILE.website;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class ILE {

	//attributes
	private String url;
	private static ArrayList<User> userList;
	private static ArrayList<Course> courseList;
	
	private ArrayList<Student> studentList;
	private ArrayList<Teacher> teacherList;
	private ArrayList<Administrator> administratorList;
	
		
	//constructor
	public ILE() {
		url = "unknown";
		userList = new ArrayList<User>();
		courseList = new ArrayList<Course>();
		
		studentList = new ArrayList<Student>();
		teacherList = new ArrayList<Teacher>();
		administratorList = new ArrayList<Administrator>();

	}
	
	//setters and getters
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String aUrl) {
		url = aUrl;
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public void setUserList(ArrayList<User> aUserList) {
		userList = aUserList;
	}
	
	public static ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(ArrayList<Course> aCourseList) {
		courseList = aCourseList;
	}
	
	//methods
	
	public void addUser(User aUser) {
		userList.add(aUser);
	}
	
	public void removeUser(User aUser) {
		userList.remove(aUser);
	}
	
	public void addCourse(Course aCourse) {
		courseList.add(aCourse);
	}
	
	public void removeCourse(Course aCourse) {
		courseList.remove(aCourse);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//Probably not using
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(ArrayList<Student> aStudentList) {
		studentList = aStudentList;
	}
	
	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}
	
	public void setTeacherList(ArrayList<Teacher> aTeacherList) {
		teacherList = aTeacherList;
	}
	
	public ArrayList<Administrator> getAdministratorList() {
		return administratorList;
	}
	
	public void setAdministratorList(ArrayList<Administrator> anAdmistratorList) {
		administratorList = anAdmistratorList;
	}
	
	public void addUser2(User aUser) {
		
		if(Student.class.isAssignableFrom(aUser.getClass())) { //user is a student
			studentList.add((Student)aUser);
		}
		
		else if(Teacher.class.isAssignableFrom(aUser.getClass())) { //user is a teacher
			teacherList.add((Teacher)aUser);
		}
		
		else { //user is an administrator
			administratorList.add((Administrator)aUser);
		}
	}
	
	public void addStudent(Student aStudent) {
		studentList.add(aStudent);
	}
	
	public void removeStudent(Student aStudent) {
		studentList.remove(aStudent);
	}
	
	public void addTeacher(Teacher aTeacher) {
		teacherList.add(aTeacher);
	}
	
	public void removeTeacher(Teacher aTeacher) {
		teacherList.remove(aTeacher);
	}
	
	public void addAdministrator(Administrator anAdministrator) {
		administratorList.add(anAdministrator);
	}
	
	public void removeAdministrator(Administrator anAdministrator) {
		administratorList.remove(anAdministrator);
	}
	
	//
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//validates if a new user name is not already taken
	public boolean validateNewUserName(String userName) {
		
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getAccount().getUserName().equals(userName)) {
				//System.out.println("Username already taken. Please choose another");
				return false;
			}
		}
				
		return true;
		
//		for (int i = 0; i < studentList.size(); i++) {
//			if(studentList.get(i).getAccount().getUserName().equals(userName)) {
//				System.out.println("Username already taken. Please choose another");
//				return false;
//			}
//		}
//		
//		for (int i = 0; i < teacherList.size(); i++) {
//			if(teacherList.get(i).getAccount().getUserName().equals(userName)) {
//				System.out.println("Username already taken. Please choose another");
//				return false;
//			}
//		}
//
//		for (int i = 0; i < administratorList.size(); i++) {
//			if(administratorList.get(i).getAccount().getUserName().equals(userName)) {
//				System.out.println("Username already taken. Please choose another.");
//				return false;
//			}
//		}

	}
	
	//validates if a new password is acceptable
	public User validateUsernameAndPassWord(String username, String password) {
		Boolean usernameMatch = false;
		
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getAccount().getUserName().equals(username)) {
				
				usernameMatch = true;
				
				if(userList.get(i).getAccount().validatePassword(password)) {

					return userList.get(i); //username and password match
				}
				
				else {
					return null; //valid username but no matching password
				}
			}
		}
		
		if(usernameMatch == false) {
			return null; //not a valid username
		}
		
		return null;
	}
	
	public boolean validateNewPassword(String password) {
		
//		if(password.length() < 8) {
//			System.out.println("Password must be more than 8 characters. Please choose another.");
//			return false;
//		}
				
		return true;
	}
	
	
	
	//Command User Interface
	//Initialization Login Screen
	public void loginScreen() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Interactive Learning Environment");
		
		Boolean continueLoop = true;
		
		while(continueLoop) {
			
			System.out.println( "1 - Login\n" + 
								"2 - Create Account\n" +
								"0 - Exit Program\n" + 
								"Enter an option: ");
			
			int optionInt = input.nextInt();
					
			switch(optionInt) {
				
				case 0: //quit
					input.close();
					continueLoop = false;
					return;
			
				case 1: //login
					login(input);
					//input.close();
					break;
				
				case 2: //create account
					createAccount(input);
					//input.close();
					break;
				
				default: 
					System.out.println("Enter a valid option");
					break;
			} //switch(optionInt)
		} //while(continueLoop)
	}
	
	//create a new account
	public void createAccount(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
			
		int accountType = 0;
		Boolean validInput = false;
				
		while(!validInput) {
		
			System.out.println( "Is this account for a student, teacher, or administrator?\n" + 
					"1 - Student\n" +
					"2 - Teacher\n" +
					"3 - Administrator\n" + 
					"Enter 1/2/3: ");
			
			accountType = input.nextInt();
			
			if (accountType == 1 || accountType == 2 || accountType == 3) {
				validInput = true;
				
			}
			else {
				System.out.println("Enter a valid option.");
			}
		} //while(!validInput)
								
		System.out.println("Enter your name: ");
		String name = input.next();
	
		validInput = false;
		String userName = "";
		String password  = "";
		
		while (!validInput) {
			
			System.out.println("Enter a user name: ");
			userName = input.next();
			
			if(validateNewUserName(userName)) {
				validInput = true;
			}
		 } //while (!validInput)
		
		 validInput = false;
				 
		 while (!validInput) {
						
			System.out.println("Password must be 8 or more characters. Enter a password: ");
			password = input.next();
		
			if(validateNewPassword(password)) {
				validInput = true;
			}
		}  //while (!validInput)
					
		switch(accountType) {
					
			case 1:
				Student newStudent = new Student();
				newStudent.setName(name);
				newStudent.getAccount().setUserName(userName);
				newStudent.getAccount().setPassword(password);
				addUser(newStudent);
				break;
			
			case 2:
				Teacher newTeacher = new Teacher();
				newTeacher.setName(name);
				newTeacher.getAccount().setUserName(userName);
				newTeacher.getAccount().setPassword(password);
				addUser(newTeacher);
				break;
			
			case 3:
				Administrator newAdministrator = new Administrator();
				newAdministrator.setName(name);
				newAdministrator.getAccount().setUserName(userName);
				newAdministrator.getAccount().setPassword(password);
				addUser(newAdministrator);
				break;
		
			default:
				break;
		}
	
		//input.close();
		
		return;
	}

	//login screen
	public void login(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		Boolean continueLoop = true;
		
		String username = "", password = "";
		
		while(continueLoop) {
						
			System.out.println("Enter username (or q to quit): ");
			
			username = input.next();
			
			if(username.equals("q")) {
				return;
			}
			
			System.out.println("Enter password: ");
			
			password = input.next();
			
			Boolean usernameMatch = false;
			
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getAccount().getUserName().equals(username)) {
					
					usernameMatch = true;
					
					if(userList.get(i).getAccount().validatePassword(password)) {
						continueLoop = false;
						//input.close();
						userList.get(i).userHomePage(input);
					}
					
					else {
						System.out.println("The password and username do not match. Please try again.");
						continueLoop = true;
						break;
					}
				}
			}
			
			if(usernameMatch == false) {
				System.out.println("The username does not match. Please try again.");
				continueLoop = true;
			}
		
		} //while(continueLoop)
		
		//input.close();
		
		return;
	}
	
	//assign an issue to the administrator with the fewest current issues
	public static void assignIssue(Issue anIssue) {
		
		int minArrayNum = 0, min = 0;
		Administrator temp;
								
		for (int i = 0; i < userList.size(); i++) {
			if (Administrator.class.isAssignableFrom(userList.get(i).getClass())) {
				
				temp = (Administrator)userList.get(i);
				
				if(min == 0) {
					min = temp.getIssueList().size();
					minArrayNum = i;
				}
				
				else if (temp.getIssueList().size() <= min) {
				
					min = temp.getIssueList().size();
					minArrayNum = i;
				}
			}
		}
		
		if(userList.size() != 0) {
			temp = (Administrator)userList.get(minArrayNum);
			temp.addIssue(anIssue);
		}
		
		return;
		
	}
	
	//public void assignIssue(Issue anIssue) {
	//	
	//	int minArrayNum = 0, min = 0;
	//					
	//	for (int i = 0; i < administratorList.size(); i++) {
	//		if (administratorList.get(i).getIssueList().size() <= min) {
	//			minArrayNum = i;
	//		}
	//	}
	//	
	//	administratorList.get(minArrayNum).addIssue(anIssue);
	//}
	
}
