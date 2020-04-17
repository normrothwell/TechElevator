package com.techelevator.validation.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Login {
	
	@NotBlank (message = "Email is a required field")
	@Email(message = "Please enter a valid email address")
	private String email;
	@NotBlank(message = "Password is required")
	@Size (min = 8, message = "Please enter a valid password")
	private String password;
	
	
	
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

}
