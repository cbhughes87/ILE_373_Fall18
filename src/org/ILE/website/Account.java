package org.ILE.website;

import java.util.ArrayList;

import org.ILE.course.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Account {

	//attributes
	private String userName;
	private String password;
	
	//constructor
	public Account() {
		userName = "unknown";
		password = "unknown";
	}
	
	
	//setters and getters
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String aUserName) {
		userName = aUserName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String aPassword) {
		password = aPassword;
	}
	
	//methods
	public Boolean validatePassword(String aPassword) {
		return(aPassword.equals(password));
	}
}
