package com.vipdsilva.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDetailsRequestModel {
	
	@NotEmpty(message = "firstName não pode ser vazio")
	private String firstName;
	
	@NotEmpty(message = "lastName não pode ser vazio")
	private String lastName;
	
	@NotEmpty(message = "email não pode ser vazio")
	@Email
	private String email;
	
	@NotEmpty(message = "password não pode ser vazio")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
}
