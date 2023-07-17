package com.jsp.college.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Admin {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@NotNull(message = "Emailid cannot be null.")
		@Email(message = "Enter valid Email Id.")
		@Column(unique = true)
		private String emailid;
		
		@NotNull(message = "Password cannot be null.")
		private String password;
		
		@NotNull(message = "role cannot be null.")
		private String role;
		
		public int getId() 
		{
			return id;
		}
		
		public String getRole() 
		{
			return role;
		}

		public void setRole(String role)
		{
			this.role = role;
		}

		public String getEmailid() 
		{
			return emailid;
		}
		
		public void setEmailid(String emailid)
		{
			this.emailid = emailid;
		}
		
		public String getPassword() 
		{
			return password;
		}
		
		public void setPassword(String password) 
		{
			this.password = password;
		}

		@Override
		public String toString() {
			return "Admin [id=" + id + ", emailid=" + emailid + ", password=" + password + ", role=" + role + "]";
		}

		
	
	
}
