package com.vipdsilva.app.ws.userservice;

import java.util.Map;


import com.vipdsilva.app.ws.ui.model.request.UpdateDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vipdsilva.app.ws.ui.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetails, Map<String, UserRest> users);
	UserRest updateUser(String userId, UpdateDetailsRequestModel userDetails, Map<String, UserRest> users);
	void deleteUser(String userId, Map<String, UserRest> users);
}
