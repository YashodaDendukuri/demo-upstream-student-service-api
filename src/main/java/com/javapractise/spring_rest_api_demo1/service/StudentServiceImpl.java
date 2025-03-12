package com.javapractise.spring_rest_api_demo1.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.javapractise.spring_rest_api_demo1.bean.CollegeDTO;
import com.javapractise.spring_rest_api_demo1.bean.Student;
import com.javapractise.spring_rest_api_demo1.bean.StudentDTO;
import com.javapractise.spring_rest_api_demo1.exception.CollegeServiceDownException;
import com.javapractise.spring_rest_api_demo1.exception.StudentNotFoundException;
import com.javapractise.spring_rest_api_demo1.exception.StudentNotRegisteredException;
import com.javapractise.spring_rest_api_demo1.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{
	private StudentRepository studentRepository;
	private RestTemplate restTemplate;
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public StudentServiceImpl(StudentRepository studentRepository,RestTemplate restTemplate) {
		this.studentRepository = studentRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public int createStudent(StudentDTO studentDTO) {
		try {
		CollegeDTO collegeDTO = restTemplate.getForObject("http://localhost:8082/colleges/"+studentDTO.collegeId(),CollegeDTO.class);
		System.err.println(collegeDTO.name());
		Student student =studentRepository.saveAndFlush(new Student(studentDTO.studentName(),studentDTO.email(),collegeDTO.name(),collegeDTO.university()));
		return (int)student.getId();
		}
		catch (HttpClientErrorException | HttpServerErrorException e) {
			logger.error("HTTP error: " + e.getStatusCode() + ", " + e.getResponseBodyAsString());
			throw new CollegeServiceDownException(e);
		} catch (ResourceAccessException e) {
			logger.error("Network issue: " + e.getMessage());
			throw new CollegeServiceDownException(e);
		} catch (RestClientException e) {
			logger.error("RestClientException: " + e.getMessage());
			throw new CollegeServiceDownException(e);
		}
		catch(Exception e) {
			throw new StudentNotRegisteredException(e);
		}
	}

	
	@Override
	public StudentDTO getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student not found with id :"+studentId));
		 return new StudentDTO(studentId,student.getName(),student.getEmail(),new ArrayList(),1);
	}

}
