package com.vipdsilva.app.ws.userservice.inMemory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.vipdsilva.app.ws.ui.model.response.UserRest;

public class UsersRepository {

	Map<String, UserRest> users;
	
	
	public Map<String, UserRest> execute() {
		
		String[] lastNames = {"Um", "Dois", "Tres"};
		
		for (int i = 0; i < lastNames.length; i++) {
			
			UserRest usuario = new UserRest();
			usuario.setFirstName("Usuario");
			usuario.setLastName(lastNames[i]);
			usuario.setEmail(lastNames[i] + "@email.com");
			
			String userId = UUID.randomUUID().toString();
			usuario.setUserId(userId);
			
			if(users == null) users = new HashMap<>();
			//System.out.println(usuario.getEmail());
			users.put(userId, usuario);
		}
		
		return users;
		
	}
	
	
}
