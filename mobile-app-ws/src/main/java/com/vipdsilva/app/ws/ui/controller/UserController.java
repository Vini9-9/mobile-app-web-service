package com.vipdsilva.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.vipdsilva.app.ws.userservice.UserService;
import com.vipdsilva.app.ws.userservice.inMemory.UsersRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, UserRest> users = new UsersRepository().execute();
	
	@Autowired
	UserService userService;

	@GetMapping
	public Map<String, UserRest> getUser(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="10") int limit,
			@RequestParam(value="sort", defaultValue="asc") String sort
			) 
	{
		
		if(users.isEmpty()) throw new UserServiceException("Nenhum usuário foi cadastrado.");
		
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
		
		UserRest returnValue = userService.createUser(userDetails, users);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}")
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateDetailsRequestModel body) {
		
		UserRest returnValue = userService.updateUser(userId, body, users);

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		
		userService.deleteUser(userId, users);
		
		return ResponseEntity.noContent().build();
	}
}
