package org.ILE.user;

import java.util.ArrayList;

import org.ILE.course.Course;
import org.ILE.interaction.Message;

public abstract class SchoolUser extends User {

	//attributes
	private ArrayList<Course> courseList;
	
	
	//constructor
	public SchoolUser( ) {
		courseList = new ArrayList<Course>();
		
	}
	
	//getters and setters
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(ArrayList<Course> aCourseList) {
		courseList = aCourseList;
	}
	
	
	
	//methods
	public abstract void addCourse(Course aCourse); 
//	{
//		courseList.add(aCourse);
//		return;
//	}
	
	public abstract void removeCourse(Course aCourse);
//	{
//		courseList.remove(aCourse);
//		return;
//	}
	
	
	
}
