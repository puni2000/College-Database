package com.jsp.college.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.college.module.User;
import com.jsp.college.module.UserCredentials;
import com.jsp.college.repo.UserRepo;


@RestController
@RequestMapping("/login")
public class LoginController {


	@Autowired
	AdminController admin;

	@Autowired
	TrainerController trainer;

	@Autowired
	StudentController student;

	@Autowired
	UserRepo userRepository;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	String s = "";

	@PostMapping
	public ResponseEntity login(@RequestBody UserCredentials credentials) 
	{
		User user = userRepository.findByUsername(credentials.getUsername());
		if (user != null && user.getPassword().equals(credentials.getPassword()) && user.getRole().equals("admin")) 
		{
			logger.info("Logging in");

			 s = UUID.randomUUID().toString();

			admin.tok=s;

			return ResponseEntity.status(HttpStatus.OK).body("Login Successful.."+"\nAccess Token: "+s+"\nRole: "+user.getRole());
		}
		else if(user != null && user.getPassword().equals(credentials.getPassword()) && user.getRole().equals("trainer"))
		{
			logger.info("Logging in");

			s = UUID.randomUUID().toString();

			trainer.tok=s;
			trainer.email=user.getUsername();

			return ResponseEntity.status(HttpStatus.OK).body("Login Successful.."+"\nAccess Token: "+s+"\nRole: "+user.getRole());

		}
		else if(user != null && user.getPassword().equals(credentials.getPassword()) && user.getRole().equals("student"))
		{
			logger.info("Logging in");

			s = UUID.randomUUID().toString();

			student.token=s;
			student.email=user.getUsername();

			return ResponseEntity.status(HttpStatus.OK).body("Login Successful.."+"\nAccess Token: "+s+"\nRole: "+user.getRole());

		}
		else 
		{
			logger.warn("Unauthorized access");

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}

	}
}





