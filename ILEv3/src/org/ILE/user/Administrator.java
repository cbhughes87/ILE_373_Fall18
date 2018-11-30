package org.ILE.user;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.website.*;

public class Administrator extends User {

	//attributes
	private ArrayList<Issue> issueList;
	
	//constructor
	public Administrator() {
		issueList = new ArrayList<Issue>();
	}
	
	//getters and setters
	public ArrayList<Issue> getIssueList() {
		return issueList;
	}
	
	public void setIssueList(ArrayList<Issue> anIssueList) {
		issueList = anIssueList;
	}
	
	//methods
	public void addIssue(Issue anIssue) {
		issueList.add(anIssue);
	}
	
	public void fixIssue(Issue anIssue) {
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
									"1 - View Issues\n" + 
									"0 - Logout");
				
				optionInt = input.nextInt();
				
				if(optionInt < 0 || optionInt > 1) {
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
					myIssues(input);
					break;
					
				default:
					System.out.println("Enter a valid option.");
					break;
			}
		
		} //while(continueLoop)
		
		return;
	}
	
	public void logout() {}
	
	public void myIssues(Scanner input) {
		
		//Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < issueList.size(); i++) {
			
			System.out.println((i + 1) + " - " + issueList.get(i).getIssue());
		}
		
		System.out.println("Enter the issue number to fix the issue or 0 to return to your homepage: ");
		
		Boolean validInput = false;
		
		int optionInt = 0;
		
		while(!validInput) {
		
			optionInt = input.nextInt();
			
			if(optionInt < 0 || optionInt > issueList.size() + 1) {
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
			fixIssue(issueList.get(optionInt - 1));
		}
		
		return;
		
	}

}
