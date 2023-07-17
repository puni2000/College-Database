package com.jsp.college.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.college.module.Student;
import com.jsp.college.module.Trainer;
import com.jsp.college.service.TrainerService;


@RestController
@RequestMapping("/trainer")
public class TrainerController {

	private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);

	@Autowired
	TrainerService service; 

	String tok;

	String email;


	@GetMapping("/details")
	ResponseEntity viewDetails()
	{
		logger.info("Request received to fetch Trainer Details..");

		if(email!=null)
		{

			return new ResponseEntity<Trainer>(service.getDetails(email),HttpStatus.FOUND);
		}
		else 		
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized Access");

	}

	@PostMapping("/addStudent_Trainer")
	ResponseEntity addStudent(@RequestBody Student s,@RequestHeader String token)
	{
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			logger.info("Request received to save Student");

			return new ResponseEntity<Student>(service.addStudent(s),HttpStatus.CREATED);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized Access");
		}
	}

	@GetMapping("/getStudent_Trainer")
	ResponseEntity getStudent(@RequestHeader String email,@RequestHeader String token)
	{
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			logger.info("Request received to search Student");

			return new ResponseEntity<Student>(service.getStudent(email),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized Access");
		}
	}

	@GetMapping("/getStudentByGrade_Trainer")
	ResponseEntity getStudentByGrade(@RequestHeader String grade,@RequestHeader String token)
	{
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			logger.info("Request received to search students by grade");

			return new ResponseEntity<List<Student>>(service.getStudentByGrade(grade),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized Access");
		}
	}

	@GetMapping("/getStudentsByBranch_Trainer")
	ResponseEntity getstudentsByBranch(@RequestHeader String branch,@RequestHeader String token)
	{
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			logger.info("Request received to fetch all Students based on Branch..");

			return new ResponseEntity<List<Student>>(service.getStudentByBranch(branch),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized Access");
		}
	}

	@RequestMapping("/logout")
	ResponseEntity logout()
	{
		if(tok!=null && email!=null)
		{
			tok=null;
			email=null;
			return ResponseEntity.status(HttpStatus.OK).body("Session Expired...");
		}
		else

			return ResponseEntity.status(HttpStatus.OK).body("Please login...");

	}

}
