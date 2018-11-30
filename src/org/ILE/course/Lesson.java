package org.ILE.course;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.website.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Lesson {

	//attributes
	private int number;
	private Course course;
	private ArrayList<Video> videoList;
	private Quiz quiz;
	
	//constructor
	public Lesson() {
		number = 0;
		course = new Course();
		videoList = new ArrayList<Video>();
		quiz = new Quiz();
	}
	
	
	//setters and getters
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int aNumber) {
		number = aNumber;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course aCourse) {
		course = aCourse;
	}
	
	public ArrayList<Video> getVideoList() {
		return videoList;
	}
	
	public void setVideoList(ArrayList<Video> aVideoList) {
		videoList = aVideoList;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz aQuiz) {
		quiz = aQuiz;
		aQuiz.setLesson(this);
	}
	
	//methods
	public void addVideo(Video aVideo) {
		videoList.add(aVideo);
		aVideo.setLesson(this);
	}
	
	//Command User Interface
	public void coursePage(Scanner input) {}
	
}
