package com.boot.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dto.StudentDto;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repo.StudentRepository;
import com.boot.service.StudentService;

@Service
public class StudentServiceImpleementation  implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDto saveStudent(StudentDto student) 
	{
		StudentEntity studentEntity = studentDtoToStudentEntity(student);
		
		StudentEntity savedObj = studentRepository.save(studentEntity);
		
		return studentEntityToStudentDto(savedObj);
	}
	
	
	public StudentEntity studentDtoToStudentEntity(StudentDto studentDto)
	{
		  StudentEntity  entity = new StudentEntity();
		  entity.setStudentId(studentDto.getStudentId());
		  entity.setStudentName(studentDto.getStudentName());
		  entity.setStudentEmail(studentDto.getStudentEmail());
		  entity.setStudentAge(studentDto.getStudentAge());
		  entity.setPassword(studentDto.getPassword());
		  
		  return entity;
	}
	
	public StudentDto  studentEntityToStudentDto(StudentEntity entity)
	{
		StudentDto  studentDto = new StudentDto();
		
		 studentDto.setStudentId(entity.getStudentId());
		  studentDto.setStudentName(entity.getStudentName());
		  studentDto.setStudentEmail(entity.getStudentEmail());
		  studentDto.setStudentAge(entity.getStudentAge());
		  studentDto.setPassword(entity.getPassword());
		  
		
		return studentDto;
	}


	@Override
	public List<StudentDto> getAllStudents() {
		
		 List<StudentEntity> studentList = studentRepository.findAll();
		    List<StudentDto> studentDtoList = studentList.stream().map((st)->studentEntityToStudentDto(st)).collect(Collectors.toList());
		
		return studentDtoList;
	}


	@Override
	public StudentDto getStudentById(int studentId) 
	{
	   
	     Optional<StudentEntity> studentObj= studentRepository.findById(studentId);
	     if(studentObj.isPresent())
	     {
	    	   StudentEntity studentyEntity= studentObj.get();
	    	   return studentEntityToStudentDto(studentyEntity);
	    	     
	    }
	    else
	    {
	    	throw new ResourceNotFoundException(studentId,"Student ID","Student Record is not exist with Id  :  "+studentId);
	    }
		
	}


	@Override
	public void deleteStudentById(int studentId) {
		
		Optional<StudentEntity> studentObj= studentRepository.findById(studentId);
	     if(studentObj.isPresent())
	     {
	    	   studentRepository.deleteById(studentId);
	    	     
	    }
	    else
	    {
	    	throw new ResourceNotFoundException(studentId,"Student ID","Student Record is not exist with Id  :  "+studentId);
	    }
	}


	@Override
	public StudentDto updateStudentById(StudentDto student, int studentId)
	{
		Optional<StudentEntity> studentEntity= studentRepository.findById(studentId);
	     if(studentEntity.isPresent())
	     {
	    	      StudentEntity studentDB =   studentEntity.get();
	    	      
	    	      studentDB.setStudentId(student.getStudentId());
	    	      studentDB.setStudentName(student.getStudentName());
	    	      studentDB.setStudentAge(student.getStudentAge());
	    	      studentDB.setStudentEmail(student.getStudentEmail());
	    	      studentDB.setPassword(student.getPassword());
	    	      
	    	      StudentEntity updated = this.studentRepository.save(studentDB);
	    	      
	    	      return  studentEntityToStudentDto(updated);
	    	     
	    }
	    else
	    {
	    	throw new ResourceNotFoundException(studentId,"Student ID","Student Record is not exist with Id  :  "+studentId);
	    }
		
		
	}



	@Override
	public StudentDto findStudentByEmail(String email) {
		 
		  List<StudentEntity> studentEmail = studentRepository.findByStudentEmail(email);
		
		   return studentEntityToStudentDto(studentEmail.get(0));
	}

}
