package com.boot.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 *    student (studentId, studentName, email, studentAge, address)

         courses (courseId, courseName, courseFee, duration)
 */
@Entity
@Table(name = "student_tbl")
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	@Column(name = "student_name",nullable = false)
	private String studentName;
	
	@Column(name = "student_email",nullable = false,unique = true)
	private String studentEmail;
	
	@Column(name = "student_age",nullable = false)
	private int studentAge;
	
	@Column(name = "student_password",nullable = false)	
	private String password;

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

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail="
				+ studentEmail + ", studentAge=" + studentAge + ", password=" + password + "]";
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
