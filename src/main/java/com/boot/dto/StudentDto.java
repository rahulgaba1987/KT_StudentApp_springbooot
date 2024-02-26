package com.boot.dto;

import java.util.ArrayList;
import java.util.List;




import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentDto 
{
    private int studentId;
	

   
	@NotEmpty
	
	@Size(min = 4,max = 10,message = "Studentname should be minimum 4 character and maximum 10")
	private String studentName;
	
	@Email
	private String studentEmail;
	
	@NotNull
	@Min(value = 10,message = "Age should be minimum 10 years")
	@Max(value = 30,message = "Age should be maximum 30 years")
	
	private int studentAge;
	
	@NotEmpty
	@Size(min = 4,max = 10,message = "Password should be minimum 4 character and maximum 10")
	//@Pattern(regexp = "")
	private String password;
	
	@JsonIgnore
	List<CourseDto> courseList = new ArrayList<>();
	

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentEmail() {
		return studentEmail;
	}


	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}


	public int getStudentAge() {
		return studentAge;
	}


	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<CourseDto> getCourseList() {
		return courseList;
	}


	public void setCourseList(List<CourseDto> courseList) {
		this.courseList = courseList;
	}


	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentAge=" + studentAge + ", password=" + password + ", courseList=" + courseList + "]";
	}
	
	
	
	

}
