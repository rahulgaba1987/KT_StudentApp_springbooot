package com.boot.service;

import java.util.List;

import com.boot.dto.CourseDto;

public interface CourseService 
{
	public CourseDto addCourse(CourseDto course);
	
	public CourseDto getCourseById(int courseId);
	
	public List<CourseDto> getAllCourse();
	
	public void deleteCourse(int courseId);
	
	public CourseDto  updateCourse(CourseDto course,int courseId);
	
	
	
	

}
