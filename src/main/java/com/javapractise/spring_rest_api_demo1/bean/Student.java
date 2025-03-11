package com.javapractise.spring_rest_api_demo1.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;
	
	private String collegeName;
	
	private String university;

	public Student(String name, String email,String collegeName,String university) {
		super();
		this.name = name;
		this.email = email;
		this.collegeName = collegeName;
		this.university = university;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}
