package com.propertysearchsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.propertysearchsystem.model.User;
import com.propertysearchsystem.repository.UserRepository;
import com.propertysearchsystem.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	
	
	UserRepository userRepository;

	public UserServiceImpl(UserRepository userrepository) {
		super();
		this.userRepository = userrepository;
	}


/*
	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		 userRepository.save(user);
		 return "user added";
	}*/

	@Override
	public User updateUser(User user, int userId) {
		// TODO Auto-generated method stub
		user.setUserId(userId);

		return userRepository.save(user);
	}



	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
	      userRepository.findAll().forEach(e -> users.add(e));
	      return users;
	}

	

}
