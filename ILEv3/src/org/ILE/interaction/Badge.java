package org.ILE.interaction;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.user.*;

public class Badge {

	//attributes
	private String name;
	private String requirements;
	private double percentRequired;
	private Quiz quiz;
	
	
	//constructor
	public Badge() {
		name = "unknown";
		requirements = "unknown";
		percentRequired = 0.0;
		//quiz = new Quiz();
	}
	
	//setters and getters
	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getRequirements() {
		return requirements;
	}
	
	public void setRequirement(String aRequirement) {
		requirements = aRequirement;
	}
	
	public double getPercentRequired() {
		return percentRequired;
	}
	
	public void setPercentRequired(double aPercent) {
		percentRequired = aPercent;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz aQuiz) {
		quiz = aQuiz;
	}
	
	//methods
	public void awardBadge(Student aStudent) {
		aStudent.addBadge(this);
	}
	
}
