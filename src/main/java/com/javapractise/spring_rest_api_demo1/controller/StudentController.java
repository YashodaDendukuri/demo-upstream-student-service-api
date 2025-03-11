package com.javapractise.spring_rest_api_demo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javapractise.spring_rest_api_demo1.bean.StudentDTO;
import com.javapractise.spring_rest_api_demo1.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private  StudentService studentService;

	
	@GetMapping("/students")
	public List<StudentDTO> getStudents() {
		List<StudentDTO> studentList = new ArrayList<>();
		studentList.add(new StudentDTO(null,"yashoda","yashoda@gmail.com",null,0));
		studentList.add(new StudentDTO(null,"balaj","balaji@gmail.com", null,0));
		
		return studentList;
	}
	
	//REST API with Path Variable
	@GetMapping("/students/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int studentId){
		return studentService.getStudent(studentId);
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentDTO> registerStudent(@Valid @RequestBody StudentDTO studentDTO){
		System.err.println(studentDTO);
		studentService.createStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);
	}
}
