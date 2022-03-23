package com.vipdsilva.app.ws.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class UpdateDetailsRequestModel {

	@NotEmpty(message = "firstName não pode ser vazio")
	private String firstName;
	
	@NotEmpty(message = "lastName não pode ser vazio")
	private String lastName;
	

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

}
