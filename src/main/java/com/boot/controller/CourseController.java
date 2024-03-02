package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dto.CourseDto;
import com.boot.exception.ApiResponse;
import com.boot.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController 
{
	@Autowired
	private CourseService courseService;

	
	@PostMapping("/")
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto course)
	{
		
		    CourseDto savedCourse = this.courseService.addCourse(course);
		    return new ResponseEntity<CourseDto>(course,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CourseDto>> getAllCourse()
	{
		
		   List<CourseDto> allCourse = this.courseService.getAllCourse();
		    return new ResponseEntity<List<CourseDto>>(allCourse,HttpStatus.OK);
	}
	// Get course by Id
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("courseId") int courseId)
	{
		
		   CourseDto courseById = this.courseService.getCourseById(courseId);
		    return new ResponseEntity<CourseDto>(courseById,HttpStatus.OK);
	}
	
	// delete course
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ApiResponse> deleteCourseById(@PathVariable("courseId") int courseId)
	{
		
		   this.courseService.deleteCourse(courseId);
		   ApiResponse response = new ApiResponse();
		     response.setMessage("Course record is delete successfully with Id  :"+courseId);
		     
		     return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
	
	// Update course
	@PutMapping("/{courseId}")
	public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto course,@PathVariable("courseId") int courseId)
	{
		
		    CourseDto updatedCourse = this.courseService.updateCourse(course,courseId);
		    return new ResponseEntity<CourseDto>(updatedCourse,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
