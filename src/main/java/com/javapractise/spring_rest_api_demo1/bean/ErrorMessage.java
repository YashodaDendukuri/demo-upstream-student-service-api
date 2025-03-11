package com.javapractise.spring_rest_api_demo1.bean;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private HttpStatus status;
	private String message;
	public ErrorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}

}
