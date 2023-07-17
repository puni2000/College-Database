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
import com.jsp.college.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	TrainerRepo trepo ;

	@Autowired
	StudentRepo srepo;

	@Autowired
	UserRepo urepo;

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	User user;
	@Override
	public Trainer addTrainer(Trainer t) 
	{

		user = new User();
		user.setPassword(t.getPassword());
		user.setUsername(t.getEmail());
		user.setRole(t.getRole());
		urepo.save(user);

		logger.info("Trainer added successfully:");

		return trepo.save(t);
	}

	@Override
	public Trainer updateTrainer(Trainer t) {
		Trainer t1 = trepo.findByUsername(t.getEmail());
		if(t1 != null)
		{

			t1.setDept(t.getDept());
			t1.setDesg(t.getDesg());
			t1.setEmail(t.getEmail());
			t1.setName(t.getName());
			t1.setPassword(t.getPassword());
			t1.setPhno(t.getPhno());
			t1.setRole(t.getRole());

			User u1 = urepo.findByUsername(t.getEmail());
			u1.setUsername(t.getEmail());
			u1.setPassword(t.getPassword());
			u1.setRole(t.getRole());
			urepo.save(u1);

			logger.info("Trainer details Updated successfully:");

			return trepo.save(t1);
		}
		else 
		{
			logger.info("Trainer Not found..!!");

			throw new DataNotFoundException("Trainer", "email", t.getId());
		}
	}

	@Override
	public Trainer findTrainer(String email) {
		Trainer e = trepo.findByUsername(email);
		if(e != null)
		{
			logger.info("Trainer found..");

			return e;
		}
		else
		{
			logger.info("Trainer with username "+email+" Not found..!!");

			throw new DataNotFoundException("Employee", "email", email);
		}
	}

	@Override
	public Trainer deleteTrainer(String email) {
		Trainer t = trepo.findByUsername(email);
		if(t != null)
		{
			User u1 = urepo.findByUsername(t.getEmail());
			urepo.delete(u1);

			trepo.delete(t);

			logger.info("Trainer with username "+email+" Deleted Successfully");

			return t;
		}
		else
		{
			logger.info("Trainer with username "+email+" Not found..!!");

			throw new DataNotFoundException("Trainer", "email", email);
		}
	}

	@Override
	public List<Trainer> getAllTrainer() {
		List<Trainer> t = trepo.getAllTrainer();
		if(!t.isEmpty())
		{
			logger.info("Trainers details fetched Successfully");

			return t;
		}
		else
		{
			logger.info("Trainers Not found..!!");

			throw new DataNotFoundException("Trainer", null, null);
		}
	}

	@Override
	public List<Trainer> getTrainerByDept(String dept) {
		List<Trainer>t = trepo.getByDept(dept);
		if(!t.isEmpty())
		{
			logger.info("Trainers details fetched successfully based on Dept..");

			return t;
		}
		else 
		{
			logger.info("Trainer details Not found..!!");

			throw new DataNotFoundException("Trainer", " not found", null);

		}	
	}

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
	public Student updateStudent(Student s) {
		Student s1 = srepo.findByUsername(s.getEmail());
		if(s1 != null)
		{
			s1.setBranch(s.getBranch());
			s1.setDegree(s.getDegree());
			s1.setEmail(s.getEmail());
			s1.setGrade(s.getGrade());
			s1.setName(s.getName());
			s1.setPassword(s.getPassword());
			s1.setPhno(s.getPhno());
			s1.setTotalMarks(s.getTotalMarks());

			User u1 = urepo.findByUsername(s.getEmail());
			u1.setUsername(s.getEmail());
			u1.setPassword(s.getPassword());
			u1.setRole(s.getRole());
			urepo.save(u1);

			logger.info("Student details Updated successfully..");

			return srepo.save(s1);
		}
		else
		{
			logger.info("Student Not found..!!");

			throw new DataNotFoundException("Student", "Email", s.getId());

		}
	}

	@Override
	public Student getStudent(String email) {
		Student s = srepo.findByUsername(email);
		if(s != null) 
		{
			logger.info("Student found ");

			return s;
		}
		else
		{
			logger.info("Student with username "+email+" Not found..!!");

			throw new DataNotFoundException("Student", "Id", email);
		}
	}

	@Override
	public Student deleteStudent(String email) {
		Student s = srepo.findByUsername(email);
		if(s != null) 
		{
			User u1 = urepo.findByUsername(s.getEmail());
			urepo.delete(u1);

			srepo.delete(s);

			logger.info("Student with username "+email+" Deleted Successfully");

			return s;
		}
		else 
		{
			logger.info("Student with username "+email+" Not found..!!");

			throw new DataNotFoundException("Student", "id", email);
		}
	}



	@Override
	public List<Student> getAllStudent() {
		List<Student> s = srepo.getAllStudents();
		if(!s.isEmpty())
		{
			logger.info("Students details fetched successfully");

			return s;
		}
		else 
		{
			logger.info("Student details Not found..!!");

			throw new DataNotFoundException("Student", " not found", null);
		}
	}

	@Override
	public List<Student> getStudentByGrade(String grade)
	{
		List<Student> s = srepo.getStudentByGrade(grade);
		if(!s.isEmpty())
		{
			logger.info("Students details fetched successfully based on grade..");

			return s;
		}
		else 
		{
			logger.info("Student details Not found..!!");

			throw new DataNotFoundException("Student", " not found", null);

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

	



}
