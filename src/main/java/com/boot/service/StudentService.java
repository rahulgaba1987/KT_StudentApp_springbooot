package com.boot.service;
import java.util.*;
import com.boot.dto.StudentDto;

public interface StudentService 
{
	 // Add Student
     public StudentDto  saveStudent(StudentDto student);	
     
     // Get AllStudents
     public List<StudentDto> getAllStudents();
     
     //Get Student By Id
     public StudentDto  getStudentById(int studentId);
     
     // Delete student record
     public void deleteStudentById(int studentId);
     
     
     //Update StudentID
     public StudentDto  updateStudentById(StudentDto student,int studentId);
     
     

}
