package com.boot.dto;



public class CourseDto 
{
    private int courseId;
	
	private String courseName;
	
	private int courseFee;
	
	private StudentDto  student;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "CourseDto [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", student=" + student + "]";
	}

	public CourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
