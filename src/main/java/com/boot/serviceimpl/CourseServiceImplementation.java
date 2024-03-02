package com.boot.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dto.CourseDto;
import com.boot.entity.CourseEntity;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repo.CourseRepository;
import com.boot.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService
{
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CourseDto addCourse(CourseDto courseDto) 
	{
		CourseEntity courseEntity = this.mapper.map(courseDto, CourseEntity.class);
		
		CourseEntity savedCourse = courseRepository.save(courseEntity);
		return mapper.map(savedCourse, CourseDto.class);
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		
		
		
		  CourseEntity course = this.courseRepository.findById(courseId)
				     .orElseThrow(()->new ResourceNotFoundException(courseId," Course ID ","Course ID is not exists "));
         
		  return mapper.map(course, CourseDto.class); 
		  
		  //		Optional<CourseEntity> courseOptional = this.courseRepository.findById(courseId);
//		if(courseOptional.isPresent())
//		{
//			return     mapper.map(courseOptional.get(), CourseDto.class); 
//		}
//		else
//		{
//			throw new ResourceNotFoundException(courseId," Course ID ","Course ID is not exists ");
//		}
		
	}

	@Override
	public List<CourseDto> getAllCourse() 
	{
		 List<CourseDto> collectDtoList = this.courseRepository.findAll().stream().map((course)->mapper.map(course, CourseDto.class)).collect(Collectors.toList());
		
		return collectDtoList;
	}

	@Override
	public void deleteCourse(int courseId)
	{
		Optional<CourseEntity> courseObj= courseRepository.findById(courseId);
	     if(courseObj.isPresent())
	     {
	    	   courseRepository.deleteById(courseId);
	    	     
	    }
	    else
	    {
	    	throw new ResourceNotFoundException(courseId,"Course ID","Course Record is not exist with Id  :  "+courseId);
	    }
		
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto, int courseId) {
		
		Optional<CourseEntity> courseObj= courseRepository.findById(courseId);
	     if(courseObj.isPresent())
	     {
	    	   CourseEntity courseEntity = courseObj.get();
	    	   courseEntity.setCourseId(courseDto.getCourseId());
	    	   courseEntity.setCourseName(courseDto.getCourseName());
	    	   courseEntity.setCourseFee(courseDto.getCourseFee());
	    	   courseEntity.setStudent(mapper.map(courseObj, StudentEntity.class));
	    	   
	    	        CourseEntity updatedCourse = courseRepository.save(courseEntity);
	    	   
	    	   return mapper.map(updatedCourse, CourseDto.class);
	    	     
	    }
	    else
	    {
	    	throw new ResourceNotFoundException(courseId,"Course ID","Course Record is not exist with Id  :  "+courseId);
	    }
	}
	

}
