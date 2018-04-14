package com.test.spring.MongoDb.model;

import org.springframework.data.annotation.Id;

public class Student {
	@Id
	private String  studentId;
	private String name;
	private String designation;
	
	public Student(){
		
	}

	public Student(String studentId, String name, String designation) {
		this.studentId = studentId;
		this.name = name;
		this.designation = designation;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", designation=" + designation + "]";
	}

}
