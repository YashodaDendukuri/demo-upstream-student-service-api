package com.javapractise.spring_rest_api_demo1.exception;

public class CollegeServiceDownException extends RuntimeException {

	public CollegeServiceDownException(Exception e) {
		super(e);
	}
}
