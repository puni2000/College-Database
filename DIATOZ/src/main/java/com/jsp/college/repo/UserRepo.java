package com.jsp.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.college.module.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query(value="select * from user where username =?1",nativeQuery = true)
	User findByUsername(String username);
}
