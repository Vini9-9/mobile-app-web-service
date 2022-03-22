package com.vipdsilva.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String getUser(@PathVariable String userId) {
		return "get users was callled with userId = " + userId;
	}
	
	@PostMapping
	public String createUser() {
		return "create user was callled";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was callled";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was callled";
	}
}
