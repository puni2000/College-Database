package com.jsp.college.service;

import java.util.List;

import com.jsp.college.module.Student;
import com.jsp.college.module.Trainer;

public interface AdminService {

	Trainer addTrainer(Trainer t);
	
	Trainer updateTrainer(Trainer t);
	
	Trainer findTrainer(String email);
	
	Trainer deleteTrainer(String email);
	
	List<Trainer> getAllTrainer();
	
	List<Trainer> getTrainerByDept(String dept);
	
	Student addStudent(Student s);
	
	Student updateStudent(Student s);
	
	Student getStudent(String email);
	
	Student deleteStudent(String email);
	
	List<Student> getAllStudent();
	
	List<Student> getStudentByGrade(String grade);
	
	List<Student> getStudentByBranch(String branch);
	
}
