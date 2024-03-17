package com.boot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.dto.CourseDto;
import com.boot.dto.StudentDto;
import com.boot.entity.CourseEntity;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repo.StudentRepository;
import com.boot.serviceimpl.StudentServiceImpleementation;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class StudentServiceTests {
	// release
	@Autowired
	private ObjectMapper mapper;

	private StudentEntity studentEntity;

	List<CourseEntity> courseList = new ArrayList<>();

	@Mock
	private StudentRepository repository;

	@InjectMocks
	private StudentServiceImpleementation studentService;

	@BeforeEach
	public void setUp() {
		studentEntity = new StudentEntity(1, "Rahul", "rahul@gmail.com", 22, "12345", courseList);
	}

	@Test
	@DisplayName("Get All students Record tets ")
	@Order(1)
	public void getAllStudentsTest() {
		List<StudentEntity> studentList = new ArrayList<>();
		studentList.add(new StudentEntity(1, "Rahul", "rahul@gmail.com", 22, "12345", courseList));
		studentList.add(new StudentEntity(2, "Aman", "aman@gmail.com", 21, "23456", courseList));

		when(repository.findAll()).thenReturn(studentList);
		List<StudentDto> allStudents = studentService.getAllStudents();
		assertEquals(2, allStudents.size());
	}

	@Test
	@DisplayName("Add new students Record tets ")
	@Order(2)
	public void saveStudentsTestEmailExists() {

		// given
		// when(repository.findByStudentEmail(studentEntity.getStudentEmail())).thenThrow(ResourceNotFoundException.class);
		when(repository.findByStudentEmail(Mockito.anyString())).thenReturn(Optional.of(studentEntity));

		StudentDto dummyObj = new StudentDto();
		dummyObj.setStudentEmail("test");

		// when
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			// studentService.findByStudentEmail(studentEntity.getStudentEmail());
			studentService.saveStudent(dummyObj);
		});

		// then

		verify(repository, never()).save((any(StudentEntity.class)));

	}

	@Test
	@DisplayName("Add new students Record tets ")
	@Order(3)
	public void saveStudentsTest() {

		// given
		when(repository.save(any(StudentEntity.class))).thenReturn(studentEntity);

		StudentDto savedStudent = studentService.saveStudent(studentEntityToStudentDto(studentEntity));

		assertEquals("rahul@gmail.com", savedStudent.getStudentEmail());

	}

	@Test
	@DisplayName("Get student by Id ")
	@Order(4)
	public void getStudentById() {

		int studentId = 1;
		// given
		when(repository.findById(studentId)).thenReturn(Optional.of(studentEntity));

		// when
		StudentDto studentObj = studentService.getStudentById(studentId);

		// then
		assertEquals(studentEntity.getStudentId(), studentObj.getStudentId());

		when(repository.findById(studentId)).thenReturn(Optional.empty());
	
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			
			studentService.getStudentById(studentId);
		});

	}

	@Test
	@DisplayName(" Delete student by Id ")
	@Order(5)
	public void deleteStudentById() {
		int studentId = 1;
		
		//doNothing().when(repository).deleteById(Mockito.anyInt());

		when(repository.findById(studentId)).thenReturn(Optional.empty());

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			studentService.deleteStudentById(studentId);
		});

	}

	@Test
	@DisplayName("Update  student by Id ")
	@Order(5)
	public void updteStudentById() {
		int studentId = 1;
		// given
		when(repository.findById(studentId)).thenReturn(Optional.of(studentEntity));
		when(repository.save(any())).thenReturn(studentEntity);

		// when
		studentEntity.setStudentEmail("abc@gmail.com");
		System.out.println(studentEntity);
		StudentDto dummyObj = new StudentDto();
		dummyObj.setStudentId(1);
		StudentDto savedStudent = studentService.updateStudentById(dummyObj, studentId);

		// then
		assertNotNull(savedStudent);

		when(repository.findById(studentId)).thenReturn(Optional.empty());

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			// studentService.findByStudentEmail(studentEntity.getStudentEmail());
			studentService.updateStudentById(dummyObj, studentId);
		});

	}

	public StudentDto studentEntityToStudentDto(StudentEntity entity) {
		StudentDto studentDto = new StudentDto();
		System.out.println("=================" + entity.getStudentId());
		studentDto.setStudentId(entity.getStudentId());
		studentDto.setStudentName(entity.getStudentName());
		studentDto.setStudentEmail(entity.getStudentEmail());
		studentDto.setStudentAge(entity.getStudentAge());
		studentDto.setPassword(entity.getPassword());
		studentDto.setCourseList(
				entity.getCourseList().stream().map(s -> mapper.convertValue(s, CourseDto.class)).toList());

		return studentDto;
	}

//	public StudentEntity studentDtoToStudentEntity(StudentDto studentDto) {
//		StudentEntity entity = new StudentEntity();
//		entity.setStudentId(studentDto.getStudentId());
//		entity.setStudentName(studentDto.getStudentName());
//		entity.setStudentEmail(studentDto.getStudentEmail());
//		entity.setStudentAge(studentDto.getStudentAge());
//		entity.setPassword(studentDto.getPassword());
//
//		return entity;
//	}
//	

}
