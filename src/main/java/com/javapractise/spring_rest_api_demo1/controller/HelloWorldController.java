package com.javapractise.spring_rest_api_demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello World";
	}

}
