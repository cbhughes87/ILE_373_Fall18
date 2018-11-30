package org.ILE.course;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.interaction.*;
import org.ILE.user.*;

public class Video {

	//attributes
	private String name;
	private String url;
	private Lesson lesson;
	
	//constructor
	public Video() {
		name = "unknown";
		url = "unknown";
		lesson = new Lesson();
	}
		
	//setters and getters
	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String aUrl) {
		url = aUrl;
	}
	
	public Lesson getLesson() {
		return lesson;
	}
	
	public void setLesson(Lesson aLesson) {
		lesson = aLesson;
	}
		
	//methods
	
}
