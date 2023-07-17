package com.jsp.college.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.college.module.Student;
import com.jsp.college.module.Trainer;
import com.jsp.college.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController
{

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService service;

	 String tok;
	
	@PostMapping("/addTrainer")
	ResponseEntity addTrainer(@RequestBody Trainer t,@RequestHeader String token)
	{
		logger.info("Request received to add Trainer");

		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token) )
		{
			return new ResponseEntity<Trainer>(service.addTrainer(t),HttpStatus.CREATED); 
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}

	}

	@PutMapping("/updateTrainer")
	ResponseEntity updateTrainer(@RequestBody Trainer t,@RequestHeader String token)
	{
		logger.info("Request received to update Trainer");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			return new ResponseEntity<Trainer>(service.updateTrainer(t),HttpStatus.ACCEPTED);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/findTrainer")
	ResponseEntity findTrainer(@RequestHeader String email,@RequestHeader String token)
	{
		logger.info("Request received to fetch Trainer");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token))
		{
			return new ResponseEntity<Trainer>(service.findTrainer(email),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}

	}

	@DeleteMapping("/deleteTrainer")
	ResponseEntity deleteTrainer(@RequestHeader String email,@RequestHeader String token)
	{
		logger.info("Request received to delete Trainer");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		if(tok.equals(token)) 
		{
			return new ResponseEntity<Trainer>(service.deleteTrainer(email),HttpStatus.NO_CONTENT);

		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getAllTrainers")
	ResponseEntity getAllTrainer(@RequestHeader String token)
	{
		logger.info("Request received to fetch Trainers");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<List<Trainer>>(service.getAllTrainer(),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getTrainersByDept")
	ResponseEntity getTrainerByDept(@RequestHeader String dept,@RequestHeader String token)
	{
		logger.info("Request received to fetch Trainers based on Dept..");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		if(tok.equals(token)) 
		{

			return new ResponseEntity<List<Trainer>>(service.getTrainerByDept(dept),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@PostMapping("/addStudent")
	ResponseEntity addStudent(@RequestBody Student s,@RequestHeader String token)
	{
		logger.info("Request received to add Student");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<Student>(service.addStudent(s),HttpStatus.CREATED);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@PutMapping("/updateStudent")
	ResponseEntity updateStudent(@RequestBody Student s,@RequestHeader String token)
	{
		logger.info("Request received to update Student");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<Student>(service.updateStudent(s),HttpStatus.ACCEPTED);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getStudent")
	ResponseEntity getStudent(@RequestHeader String email,@RequestHeader String token)
	{
		logger.info("Request received to fetch Student");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<Student>(service.getStudent(email),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@DeleteMapping("/deleteStudent")
	ResponseEntity deleteStudent(@RequestHeader String email,@RequestHeader String token)
	{
		logger.info("Request received to delete Student");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token) ) 
		{
			return new ResponseEntity<Student>(service.deleteStudent(email),HttpStatus.NO_CONTENT);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getAllStudents")
	ResponseEntity getAllStudent(@RequestHeader String token)
	{
		logger.info("Request received to fetch all Students..");
		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token) ) 
		{
			return new ResponseEntity<List<Student>>(service.getAllStudent(),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getStudentsByGrade")
	ResponseEntity getstudentsByGrade(@RequestHeader String grade,@RequestHeader String token)
	{
		logger.info("Request received to fetch all Students based on Grade..");

		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<List<Student>>(service.getStudentByGrade(grade),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@GetMapping("/getStudentsByBranch")
	ResponseEntity getstudentsByBranch(@RequestHeader String branch,@RequestHeader String token)
	{
		logger.info("Request received to fetch all Students based on Branch..");

		if(tok==null)
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login To Proceed...");
		}
		else if(tok.equals(token)) 
		{
			return new ResponseEntity<List<Student>>(service.getStudentByBranch(branch),HttpStatus.FOUND);
		}
		else 
		{
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED ACCESS");
		}
	}

	@RequestMapping("/logout")
	ResponseEntity logout()
	{
		if(tok!=null)
		{
			tok=null;

			return ResponseEntity.status(HttpStatus.OK).body("Session Expired...");
		}
		else

			return ResponseEntity.status(HttpStatus.OK).body("Please login...");

	}


}
