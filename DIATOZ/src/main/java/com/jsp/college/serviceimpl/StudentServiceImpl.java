package com.jsp.college.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.college.exception.DataNotFoundException;
import com.jsp.college.module.Student;
import com.jsp.college.repo.StudentRepo;
import com.jsp.college.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo srepo;
	
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

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

			throw new DataNotFoundException("Student ", "ID", email);
		}
	}

}
