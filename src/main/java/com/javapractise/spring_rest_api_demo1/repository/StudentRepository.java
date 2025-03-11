package com.javapractise.spring_rest_api_demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javapractise.spring_rest_api_demo1.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
