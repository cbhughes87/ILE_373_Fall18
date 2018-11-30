package org.ILE.interaction;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.user.*;

public class Note {

	//attributes
	private String note;
	private Lesson lesson;
	
	//constructor
	public Note() {
		note = "";
		lesson = new Lesson();
	}
	
	//setters and getters
	public String getNote() {
		return note;
	}
	
	public void setNote(String aNote) {
		note = aNote;
	}
	
	public Lesson getLesson() {
		return lesson;
	}
	
	public void setLesson(Lesson aLesson) {
		lesson = aLesson;
	}
	
	//methods
	
}
