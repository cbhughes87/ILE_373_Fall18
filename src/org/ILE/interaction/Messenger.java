package org.ILE.interaction;

import java.util.ArrayList;

import org.ILE.website.*;
import org.ILE.course.*;
import org.ILE.user.*;

public class Messenger {

	//attributes
	private ArrayList<Teacher> teacherList;
	private ArrayList<Student> studentList;
	
	//constructor
	public Messenger() {
		teacherList = new ArrayList<Teacher>();
		studentList = new ArrayList<Student>();
	}
	
	//setters and getters
	
	//methods
	public ArrayList<Message> getMessages(User user){
		
		return user.getMessageList();
	}
	
	public void sendMessage(User receiver, Message msg) {
		receiver.addMessage(msg);
	}
	
	public void addTeacher(Teacher teacher) {
		teacherList.add(teacher);
	}
	
	public void removeTeacher(Teacher teacher) {
		teacherList.remove(teacher);
	}
	
	public ArrayList<Teacher> getTeacherList(){
		return teacherList;
	}
	
	public void messageTeachers(Message msg) {
		for(Teacher teacher : teacherList) {
			teacher.addMessage(msg);
		}
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void removeStudent(Student student) {
		studentList.remove(student);
	}
	
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
	public void messageStudents(Message msg) {
		for(Student student : studentList) {
			student.addMessage(msg);
		}
	}
	
	public void messageAll(Message msg) {
		this.messageTeachers(msg);
		this.messageStudents(msg);
	}
}
