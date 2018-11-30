package org.ILE.interaction;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.user.*;

public class Message {

	//attributes
	private String message;
	private User fromUser;
	private User toUser;
	private boolean read;
	
	//constructor
	public Message() {
		message = "";
		fromUser = null;
		toUser = null;
		read = false;
	}
	
	//setters and getters
	public void markRead() {
		read = true;
	}
	
	public void unmarkRead() {
		read = false;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String aMessage) {
		message = aMessage;
	}
	
	public User getFromUser() {
		return fromUser;
	}
	
	public void setFromUser(SchoolUser aUser ) {
		fromUser = aUser;
	}
	
	public User getToUser() {
		return toUser;
	}
	
	public void setToUser(SchoolUser aUser ) {
		toUser = aUser;
	}
	
	//methods
	public void sendMessage() {
		toUser.addMessage(this);
	}
	
	public void respondToMessage() {
		sendMessage();
		fromUser.removeMessage(this);
	}
}
