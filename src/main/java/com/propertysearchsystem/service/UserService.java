package com.propertysearchsystem.service;

import java.util.List;

import com.propertysearchsystem.model.User;

public interface UserService {
	List<User> getAllUsers();
	//String createUser(User user);
    User updateUser(User user, int userId);
	
	
}
