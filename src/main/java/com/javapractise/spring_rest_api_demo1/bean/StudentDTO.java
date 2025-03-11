package com.javapractise.spring_rest_api_demo1.bean;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record StudentDTO(Integer studentId,@NotBlank(message = "Name cannot be empty")  String studentName,@Email(message = "Invalid email format") String email, List<Integer> courseList,int collegeId) {
	
  public StudentDTO( Integer studentId,String studentName, String email, List<Integer> courseList,int collegeId) {
	  this.studentId = studentId;
	  this.studentName = studentName;
	  this.email = email;
	  this.collegeId = collegeId;
	  this.courseList = (courseList != null)?List.copyOf(courseList):List.of();
  }
}
