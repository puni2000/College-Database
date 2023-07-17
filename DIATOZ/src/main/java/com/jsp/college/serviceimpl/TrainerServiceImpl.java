package com.jsp.college.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.college.exception.DataNotFoundException;
import com.jsp.college.module.Student;
import com.jsp.college.module.Trainer;
import com.jsp.college.module.User;
import com.jsp.college.repo.StudentRepo;
import com.jsp.college.repo.TrainerRepo;
import com.jsp.college.repo.UserRepo;
import com.jsp.college.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{

	private static final Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

	@Autowired
	StudentRepo srepo; 

	@Autowired
	UserRepo urepo;

	@Autowired
	TrainerRepo trepo;

	User user;

	@Override
	public Student addStudent(Student s) 
	{
		user = new User();
		user.setPassword(s.getPassword());
		user.setUsername(s.getEmail());
		user.setRole(s.getRole());
		urepo.save(user);

		logger.info("Student added successfully..");

		return srepo.save(s);
	}

	@Override
	public Student getStudent(String email) {
		Student s = srepo.findByUsername(email);
		if(s != null)
		{
			logger.info("Student found..");

			return s;
		}
		else
		{
			logger.info("Student with username "+email+" Not found..!!");

			throw new DataNotFoundException("Student ","Id " , email);
		}
	}

	@Override
	public List<Student> getStudentByGrade(String grade) {
		List<Student> s = srepo.getStudentByGrade(grade);
		if(!(s.isEmpty()))
		{
			logger.info("Student with grade "+grade+" found..");

			return s;
		}
		else
		{
			logger.info("Student with grade "+grade+" Not found..!!");

			throw new DataNotFoundException("Student ","Id " , grade);
		}
	}

	@Override
	public List<Student> getStudentByBranch(String branch) {
		List<Student> s = srepo.getStudentByBranch(branch);
		if(!s.isEmpty())
		{
			logger.info("Students details fetched successfully based on branch..");

			return s;
		}
		else 
		{
			logger.info("Student details Not found..!!");

			throw new DataNotFoundException("Student", " not found", null);

		}	
	}

	@Override
	public Trainer getDetails(String email) {
		Trainer t = trepo.findByUsername(email);
		if(t != null) 
		{
			logger.info("Trainer Details fetched successfully...");
			return t;
		}
		else
		{
			logger.info("Trainer details Not found..!!");

			throw new DataNotFoundException("Trainer", " not found", null);
		}	
	}
}


