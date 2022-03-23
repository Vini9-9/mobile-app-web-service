package com.vipdsilva.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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

import com.vipdsilva.app.ws.exceptions.UserServiceException;
import com.vipdsilva.app.ws.ui.model.request.UpdateDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, UserRest> users;

	@GetMapping
	public Map<String, UserRest> getUser(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="10") int limit,
			@RequestParam(value="sort", defaultValue="asc") String sort
			) 
	{
		if(users == null) throw new UserServiceException("Nenhum usuário foi cadastrado.");
		/*
		 * if(users == null) { return "get users was called with page = " + page +
		 * " and limit = " + limit + " and sort = " + sort; } else {
		 */
			return users;

	}
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId))
		{
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			throw new UserServiceException("Usuário não localizado.");
		}
	}
	
	@PostMapping
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest usuario = new UserRest();
		usuario.setFirstName(userDetails.getFirstName());
		usuario.setLastName(userDetails.getLastName());
		usuario.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		usuario.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, usuario);
		
		return new ResponseEntity<UserRest>(usuario, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}")
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateDetailsRequestModel userDetails) {
		
		UserRest usuarioUpdate = users.get(userId);
		usuarioUpdate.setFirstName(userDetails.getFirstName());
		usuarioUpdate.setLastName(userDetails.getLastName());
		
		users.put(userId, usuarioUpdate);

		return new ResponseEntity<UserRest>(usuarioUpdate, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		
		users.remove(userId);
		
		return ResponseEntity.noContent().build();
	}
}
