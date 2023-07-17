package com.jsp.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.college.module.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Integer>
{
	@Query(value="select * from trainer where email=?1",nativeQuery = true)
	Trainer findByUsername(String email);
	
	@Query(value="select * from trainer",nativeQuery = true)
	List<Trainer> getAllTrainer();
	
	@Query(value="select * from trainer where dept=?1",nativeQuery = true)
	List<Trainer> getByDept(String dept);
}
