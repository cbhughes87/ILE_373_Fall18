package org.ILE.course;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Question {

	//attributes
	private String text;
	private String solution;
	private Quiz quiz;
	private Boolean pass;
	
	//constructor
	public Question() {
		text = "unknown";
		solution = "unknown";
		quiz = new Quiz();
		pass = false;
	}
	
	//setters and getters
	public String getText() {
		return text;
	}
	
	public void setText(String aText) {
		text = aText;
	}
	
	public String getSolution() {
		return solution;
	}
	
	public void setSolution(String aSolution) {
		text = aSolution;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz aQuiz) {
		quiz = aQuiz;
	}
	
	public Boolean getPass() {
		return pass;
	}
	
	public void setPass(Boolean aStatus) {
		pass = aStatus;
	}
	
	//methods
	
}
