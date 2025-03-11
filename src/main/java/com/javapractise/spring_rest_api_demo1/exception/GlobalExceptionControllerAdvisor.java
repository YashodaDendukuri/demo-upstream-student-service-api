package com.javapractise.spring_rest_api_demo1.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javapractise.spring_rest_api_demo1.bean.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionControllerAdvisor extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGeneralException(Exception ex){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorMessage(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage()));
	}
	
	@ExceptionHandler(CustomerNotRegisteredException.class)
	public ResponseEntity<ErrorMessage> handleCustomerServiceDownException(CustomerNotRegisteredException ex){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorMessage(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage()));
	}
	
	@ExceptionHandler(CollegeServiceDownException.class)
	public ResponseEntity<ErrorMessage> handleCollegeServiceDownException(CollegeServiceDownException ex){
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorMessage(HttpStatus.BAD_GATEWAY, ex.getMessage()));
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getMessage()));
	}
	

}
