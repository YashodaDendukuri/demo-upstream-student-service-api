package com.javapractise.spring_rest_api_demo1.exception;

public class CustomerNotRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotRegisteredException(Exception e) {
		super(e);
	}
}
