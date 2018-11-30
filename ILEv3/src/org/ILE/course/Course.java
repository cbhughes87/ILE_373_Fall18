package org.ILE.course;

import java.util.ArrayList;
import java.util.Scanner;

import org.ILE.website.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Course {

	//attributes
	private String name;
	private Teacher teacher;
	private ArrayList<Student> studentList;
	private ArrayList<Lesson> lessonList;
	//private Quiz quiz;
	
	//constructor
	public Course() {
		name = "unknown";
		teacher = new Teacher();
		studentList = new ArrayList<Student>();
		lessonList = new ArrayList<Lesson>();
		//quiz = new Quiz();
	}
	
	//setters and getters
	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher aTeacher) {
		teacher = aTeacher;
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(ArrayList<Student> aStudentList) {
		studentList = aStudentList;
	}
	
	public ArrayList<Lesson> getLessonList() {
		return lessonList;
	}
	
	public void setLessonList(ArrayList<Lesson> aLessonList) {
		lessonList = aLessonList;
	}
	
//	public Quiz getQuiz() {
//		return quiz;
//	}
//	
//	public void setQuiz(Quiz aQuiz) {
//		quiz = aQuiz;
//	}
		
	//methods
	public void addStudent(Student aStudent) {
		studentList.add(aStudent);
	}
	
	public void removeStudent(Student aStudent) {
		studentList.remove(aStudent);
	}
	
	public void addLesson(Lesson aLesson) {
		lessonList.add(aLesson);
		aLesson.setCourse(this);
	}
	
	public void removeLesson(Lesson aLesson) {
		lessonList.remove(aLesson);
	}
	
	
	//Command User Interface
	public void coursePage(Scanner input) {}
	
}
