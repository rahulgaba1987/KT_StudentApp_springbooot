package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dto.StudentDto;
import com.boot.exception.ApiResponse;
import com.boot.service.StudentService;

import jakarta.validation.Valid;




@RequestMapping("/student")
@RestController

public class StudentController 
{
	  @Autowired
	  private StudentService studentService;
	
	

	  @PostMapping("/")  // End points
	  public  ResponseEntity<StudentDto>   saveStudent(@Valid @RequestBody  StudentDto studentDto)
	  {
		         StudentDto savedStudent = studentService.saveStudent(studentDto);
		         return new ResponseEntity<StudentDto>(savedStudent,HttpStatus.CREATED);
	  }
      // ctrl+shift+T
	  
	  @GetMapping("/")
	  public ResponseEntity<List<StudentDto>>   getAllStudentsRecords()
	  {
		       List<StudentDto> allStudents = studentService.getAllStudents();
		       return new ResponseEntity<List<StudentDto>>(allStudents,HttpStatus.OK);
	  }
	               
	  @GetMapping("/{studentId}")
	  public ResponseEntity<StudentDto>  getStudentById(@PathVariable("studentId") int studentId)
	  {
		  
		       StudentDto studentById = studentService.getStudentById(studentId);
		return new ResponseEntity<StudentDto>(studentById,HttpStatus.OK);
		  
	  }
	  
	  @DeleteMapping("/{studentId}")
	  public  ResponseEntity<ApiResponse> deleteStudentById(@PathVariable("studentId") int studentId)
	  {
		  
		     studentService.deleteStudentById(studentId);
		     ApiResponse response = new ApiResponse();
		     response.setMessage("Student record is delete successfully with Id  :"+studentId);
		     
		     return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		  
	  }
	  
	  @PutMapping("/{studentId}")  // End points
	  public  ResponseEntity<StudentDto>   updateStudent( @RequestBody  StudentDto studentDto,@PathVariable("studentId") int studentId)
	  {
		         StudentDto updatedStudent = studentService.updateStudentById(studentDto,studentId);
		         return new ResponseEntity<StudentDto>(updatedStudent,HttpStatus.OK);
	  }
	  
	  @GetMapping("/email")
	  public ResponseEntity<StudentDto>   getStudentByEmail(@RequestParam("msg") String msg)
	  {
		      StudentDto studentByEmail = studentService.findStudentByEmail(msg);
		      return new ResponseEntity<StudentDto>(studentByEmail,HttpStatus.OK);
		      
	  }
	  
	
}
// http://localhost:9091/student/