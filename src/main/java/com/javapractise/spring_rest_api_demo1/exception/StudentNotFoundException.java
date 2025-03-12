package com.javapractise.spring_rest_api_demo1.exception;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message) {
		super(message);
	}
}
