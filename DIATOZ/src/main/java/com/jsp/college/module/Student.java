package com.jsp.college.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", 
	message = "Name should Start with capital letter")
	private String name;
	
	@NotNull(message = "Emailid cannot be null.")
	@Email(message = "Enter valid Email Id.")
	@Column(unique = true)
	private String email;
	
	@NotNull(message = "Password cannot be null.")
	private String password;

	@NotNull(message = "Contact number cannot be null.")
	@Column(unique = true)
	private long phno;
	
	@NotNull(message = "Degree cannot be null.")
	private String degree;
	
	@NotNull(message = "Degree cannot be null.")
	private String branch;

	@NotNull(message = "Marks cannot be null.")
	private int totalMarks;
	
	@NotNull(message = "Grade cannot be null.")
	private String grade;
	
	@NotNull(message = "Role cannot be null.")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phno=" + phno
				+ ", degree=" + degree + ", branch=" + branch + ", totalMarks=" + totalMarks + ", grade=" + grade
				+ ", role=" + role + "]";
	}

	

	
	
	
}

