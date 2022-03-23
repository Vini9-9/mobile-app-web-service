package com.vipdsilva.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;


import com.vipdsilva.app.ws.ui.model.request.UpdateDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.response.UserRest;
import com.vipdsilva.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map<String, UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails, Map<String, UserRest> users) {
		
		UserRest usuario = new UserRest();
		usuario.setFirstName(userDetails.getFirstName());
		usuario.setLastName(userDetails.getLastName());
		usuario.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		usuario.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, usuario);
		
		return usuario;
	}
	
	@Override
	public UserRest updateUser(String userId, UpdateDetailsRequestModel userDetails, Map<String, UserRest> users) {
		
		UserRest usuarioUpdate = users.get(userId);
		usuarioUpdate.setFirstName(userDetails.getFirstName());
		usuarioUpdate.setLastName(userDetails.getLastName());
		
		users.put(userId, usuarioUpdate);
		
		return usuarioUpdate;
	}

	@Override
	public void deleteUser(String userId, Map<String, UserRest> users) {
		
		users.remove(userId);

	}

}
