package com.jsp.college.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.college.module.Student;
import com.jsp.college.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	String token;
	String email;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


	@Autowired
	StudentService service;

	@GetMapping("/details")
	ResponseEntity getStudent()
	{
		logger.info("Request received to fetch Student..");

		if(email!=null && token!=null)
		{
			return new ResponseEntity<Student>(service.getStudent(email),HttpStatus.FOUND);
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
	}
	
	@RequestMapping("/logout")
	ResponseEntity logout()
	{
		if(token!=null && email!=null)
		{
			token=null;
			email=null;
			return ResponseEntity.status(HttpStatus.OK).body("Session Expired...");
		}
		else

			return ResponseEntity.status(HttpStatus.OK).body("Please login...");

	}
}
