package com.jsp.college.service;

import java.util.List;

import com.jsp.college.module.Student;
import com.jsp.college.module.Trainer;

public interface TrainerService {

	Student addStudent(Student s);
	
	Student getStudent(String email);
	
	Trainer getDetails(String email);
	
	List<Student> getStudentByGrade(String grade);

	List<Student> getStudentByBranch(String branch);

}
