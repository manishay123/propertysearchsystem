package com.propertysearchsystem.controller;

import java.util.List;

import com.propertysearchsystem.dto.AuthRequestDto;
import com.propertysearchsystem.dto.AuthResponse;
import com.propertysearchsystem.dto.ValidateStatusDto;
import com.propertysearchsystem.excpetion.LoginException;
import com.propertysearchsystem.repository.UserRepository;
import com.propertysearchsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.propertysearchsystem.model.User;
import com.propertysearchsystem.service.UserService;

@RestController
@RequestMapping()
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	ValidateStatusDto validateStatus;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is secure";
	}

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to the admin";
	}

	@GetMapping({ "/forUser" })
	@PreAuthorize("hasRole('User') || hasRole('Admin')")
	public String forUser() {
		return "This URL is only accessible to the user and admin";
	}

	@PostMapping("/createUser")
	 public ResponseEntity<User> createUser(@RequestBody User user) {
	 return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	 }


	@PutMapping("/update/{id}")
	private User updateUser(@PathVariable int userId, @RequestBody User user) {

		return userService.updateUser(user, userId);
	}

	@GetMapping("/users")
	public List<User> getAllusers() {
		return userService.getAllUsers();
	}


	@PostMapping("/login")
	public ResponseEntity<Object> createAuthorizationToken(@RequestBody AuthRequestDto authReq)
			throws AuthenticationException, LoginException {
		try {

			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authReq.getUsername(),
							authReq.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			final UserDetails userDetails = userService.loadUserByUsername(authReq.getUsername());
			User user = userRepository.findByUserName(userDetails.getUsername()).get();
			return new ResponseEntity<>(
					new AuthResponse(user, jwtTokenUtil.generateToken(authentication),
							jwtTokenUtil.getCurrentTime(), jwtTokenUtil.getExpirationTime()),
					HttpStatus.OK);

		} catch (Exception e) {
			throw new LoginException("Invalid Username or Password");
		}

	}



}
