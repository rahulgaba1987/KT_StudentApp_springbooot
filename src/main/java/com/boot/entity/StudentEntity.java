package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GeneratorType;

import com.boot.dto.CourseDto;
import com.boot.dto.StudentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *    student (studentId, studentName, email, studentAge, address)

         courses (courseId, courseName, courseFee, duration)
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

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
	
	@OneToMany(mappedBy = "student",fetch =FetchType.EAGER )
	List<CourseEntity> courseList = new ArrayList<>();

	
}
