package com.propertysearchsystem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.propertysearchsystem.excpetion.CustomMessageException;
import com.propertysearchsystem.model.User;

public interface UserService {

	
	List<User> getAllUsers();
	User createUser(User user);
    User updateUser(User user, int userId);

	UserDetails loadUserByUsername(String userName);
	
}
