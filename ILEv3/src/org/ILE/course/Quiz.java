package org.ILE.course;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Quiz {

	//attributes
	private ArrayList<Question> questionList;
	private double grade;
	private Lesson lesson;
	private Badge badge;
	private boolean rewardBadge;
	
	//constructor
	public Quiz() {
		questionList = new ArrayList<Question>();
		grade = 0.0;
		//lesson = new Lesson();
		badge = new Badge();
		badge.setQuiz(this);
		rewardBadge = false;
	}
	
	//setters and getters
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	
	public void setQuestionList(ArrayList<Question> aQuestionList) {
		questionList = aQuestionList;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setGrade(double aGrade) {
		grade = aGrade;
		if(grade >= 70) {
			rewardBadge = true;
		}
	}
	
	public Lesson getLesson() {
		return lesson;
	}
	
	public void setLesson(Lesson aLesson) {
		lesson = aLesson;
	}
	
	public Badge getBadge() {
		return badge;
	}
	
	public void setBadge(Badge aBadge) {
		badge = aBadge;
		aBadge.setQuiz(this);
	}
	
	//methods
	public void addQuestion(Question aQuestion) {
		questionList.add(aQuestion);
	}
	
	public void removeQuestion(Question aQuestion) {
		questionList.remove(aQuestion);
	}
}
