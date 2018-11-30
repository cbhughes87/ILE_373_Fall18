package org.ILE.interaction;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.user.*;

public class Issue {

	//attributes
	private String issue;
	private Boolean status;
	
	//constructor
	public Issue() {
		issue = "";
		status = false;
	}
		
	//setters and getters
	public String getIssue() {
		return issue;
	}
	
	public void setIssue(String anIssue) {
		issue = anIssue;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean aStatus) {
		status = aStatus;
	}
	
	//methods
	
}
