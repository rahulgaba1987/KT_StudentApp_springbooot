package com.boot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boot.dto.StudentDto;
import com.boot.entity.CourseEntity;
import com.boot.entity.StudentEntity;
import com.boot.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)

public class StudentControllerTests 
{
	private StudentEntity studentEntity;
	
	List<CourseEntity> courseList = new ArrayList<>();
	

	private ObjectMapper mapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService studentService;
	
	
	@BeforeEach
 	public void setUp()
 	{
		this.mapper = new ObjectMapper();
 		studentEntity = new StudentEntity(1,"Rahul","rahul@gmail.com",22,"12345",courseList);
 		
 		
 		
 		
 		
 		
 		
 	}
	
	@Test
	@Order(1)
	public void test_getAllStudents() throws Exception
	{
		StudentEntity studentEntity2 = new StudentEntity(2,"Aman","amna@gmail.com",24,"54321",courseList);
		List<StudentDto> studentList = new ArrayList<>();
 		studentList.add(mapper.convertValue(studentEntity, StudentDto.class));
 		studentList.add(mapper.convertValue(studentEntity2, StudentDto.class));
		
 		//given
 		when(studentService.getAllStudents()).thenReturn(studentList);
 		
 		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/student/");
 		ResultActions perform = mockMvc.perform(reqBuilder);
 		MvcResult mvcResult = perform.andReturn();
 		
 		MockHttpServletResponse response = mvcResult.getResponse();
 		int status = response.getStatus();
 		assertEquals(200, status);
 		
 		
		
		
	}
	
	

}
