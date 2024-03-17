package com.boot.dto;

import java.util.ArrayList;
import java.util.List;




import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto 
{
    private int studentId;
	
	@NotEmpty
	
	@Size(min = 4,max = 10,message = "Studentname should be minimum 4 character and maximum 10")
	private String studentName;
	
	@Email
	private String studentEmail;
	
	@NotNull
	@Min(value = 10,message = "Age should be minimum 10 years")
	@Max(value = 30,message = "Age should be maximum 30 years")
	
	private int studentAge;
	
	@NotEmpty
	@Size(min = 4,max = 10,message = "Password should be minimum 4 character and maximum 10")
	//@Pattern(regexp = "")
	private String password;
	
	@JsonIgnore
	List<CourseDto> courseList = new ArrayList<>();
	

	

}
