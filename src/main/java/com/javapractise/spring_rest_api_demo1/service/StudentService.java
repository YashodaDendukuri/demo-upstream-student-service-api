package com.javapractise.spring_rest_api_demo1.service;

import com.javapractise.spring_rest_api_demo1.bean.StudentDTO;


public interface StudentService {

	public int createStudent(StudentDTO studentDTO);
	public StudentDTO getStudent(int studentId);
}
