package com.jsp.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.college.module.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{
	@Query(value="select * from student where email=?1",nativeQuery = true)
	Student findByUsername(String email); 
	
	@Query(value="select * from student where grade=?1",nativeQuery = true)
	List<Student> getStudentByGrade(String grade);
	
	@Query(value="select * from student",nativeQuery = true)
	List<Student> getAllStudents();
	
	@Query(value="select * from student where branch=?1",nativeQuery = true)
	List<Student> getStudentByBranch(String branch);
}
