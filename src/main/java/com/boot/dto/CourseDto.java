package com.boot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor


public class CourseDto 
{
    private int courseId;
	
	private String courseName;
	
	private int courseFee;
	
	private StudentDto  student;

	
	

}
