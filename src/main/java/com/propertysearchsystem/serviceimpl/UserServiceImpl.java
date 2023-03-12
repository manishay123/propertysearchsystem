package com.propertysearchsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.propertysearchsystem.model.User;
import com.propertysearchsystem.repository.UserRepository;
import com.propertysearchsystem.service.UserService;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {


	@Autowired
	UserRepository userRepository;


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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (userRepository.findByUserName(username).isPresent()) {
			User user = userRepository.findByUserName(username).get();
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
		}

		throw new UsernameNotFoundException("User not found!!");
	}






}
