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
public class Trainer {
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
	
	@NotNull(message = "Department cannot be null.")
	private String dept;
	
	@NotNull(message = "Designation cannot be null.")
	private String desg;
	
	@NotNull(message = "Contact number cannot be null.")
	@Column(unique = true)
	private long phno;
	
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dept=" + dept
				+ ", desg=" + desg + ", phno=" + phno + ", role=" + role + "]";
	}

	
}
