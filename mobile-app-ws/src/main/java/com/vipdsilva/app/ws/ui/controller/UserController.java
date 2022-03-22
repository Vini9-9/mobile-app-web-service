package com.vipdsilva.app.ws.ui.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vipdsilva.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	

	@GetMapping
	public String getUser(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="10") int limit,
			@RequestParam(value="sort", defaultValue="asc") String sort
			) 
	{
		return "get users was callled with page = " + page 
				+ " and limit = " + limit
				+ " and sort = " + sort;
	}
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest usuario = new UserRest();
		usuario.setFirstName("Vinicius");
		usuario.setLastName("Pessoa da Silva");
		usuario.setEmail("vipdsilva@ibm.com");
		usuario.setUserId(UUID.randomUUID());
		
		return new ResponseEntity<UserRest>(usuario, HttpStatus.OK);
	}
	
	@PostMapping
	public UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest usuario = new UserRest();
		usuario.setFirstName(userDetails.getFirstName());
		usuario.setLastName(userDetails.getLastName());
		usuario.setEmail(userDetails.getEmail());
		usuario.setUserId(UUID.randomUUID());
		return usuario;
	}
	
	@PutMapping
	public String updateUser() {
		UserRest usuario = new UserRest();
		usuario.setFirstName("Vinicius");
		usuario.setLastName("Pessoa da Silva");
		usuario.setEmail("vipdsilva@ibm.com");
		usuario.setUserId(UUID.randomUUID());
		return "update user was callled";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was callled";
	}
}
