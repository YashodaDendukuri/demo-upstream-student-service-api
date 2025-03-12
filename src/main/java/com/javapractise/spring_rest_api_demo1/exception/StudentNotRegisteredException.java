package com.javapractise.spring_rest_api_demo1.exception;

public class StudentNotRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotRegisteredException(Exception e) {
		super(e);
	}
}
