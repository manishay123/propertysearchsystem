package com.propertysearchsystem.serviceimpl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.propertysearchsystem.model.User;
import com.propertysearchsystem.repository.UserRepository;
import com.propertysearchsystem.service.UserService;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {


	@Autowired
	UserRepository userRepository;
	int strength = 10;
	BCryptPasswordEncoder bCryptPasswordEncoder =
			new BCryptPasswordEncoder(strength, new SecureRandom());

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
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoleName("User");
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (userRepository.findByUserName(username).isPresent()) {
			User user = userRepository.findByUserName(username).get();
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
		}

		throw new UsernameNotFoundException("User not found!!");
	}

	private Set getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoleName()));
		return authorities;
	}



}
