package org.ILE.user;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.website.*;

public abstract class User {
	
	//attributes
	private String name;
	private Account account;
	private Permission permissions;
	private Boolean loggedIn;
	private ArrayList<Message> messageList;
	
	//constructor
	public User() {
		name  = "unknown";
		account = new Account();
		permissions = new Permission();
		loggedIn = false;
		messageList = new ArrayList<Message>();
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account anAccount) {
		account = anAccount;
	}
	
	public Permission getPermissions() {
		return permissions;
	}
	
	public void setPermissions(Permission aPermission) {
		permissions = aPermission;
	}
	
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(Boolean aStatus) {
		loggedIn = aStatus;
	}
	
	//methods
	public abstract void userHomePage(Scanner input);
	
	
	public void reportIssue() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Write the issue you would like to report.");
		
		String issueString = input.nextLine();
		
		Issue anIssue = new Issue();
		
		anIssue.setIssue(issueString);
		
		ILE.assignIssue(anIssue);
						
		input.close();
		
		System.out.println("Thank you for reporting this issue. An administrator will be investigating it soon.");
	
		return;
	}
	
	public void logOut() {
		
		Scanner input = new Scanner(System.in);
		
		Boolean continueLoop = true;
		
		while(continueLoop) {
			
			System.out.println("Are you sure you would like to log out? (y/n)");
			
			String optionChar = input.next();
			
			if(optionChar.equals("y") || optionChar.equals("Y")) {
				setLoggedIn(false);
				input.close();
				continueLoop = false;
				return;
			}
			
			else if(optionChar.equals("n") || optionChar.equals("N")) {
				input.close();
				continueLoop = false;
				return;
			}
			
			else {
				System.out.println("Please enter a valid option.");
				continueLoop = true;
			}
		}
	}
	
	public void addMessage(Message aMessage) {
		messageList.add(aMessage);
		return;
	}
	
	public void removeMessage(Message aMessage) {
		messageList.remove(aMessage);
		return;
	}
	
	public ArrayList<Message> getMessageList() {
		return messageList;
	}
	
	public void setMessageList(ArrayList<Message> aMessageList) {
		messageList = aMessageList;
	}
	

}
