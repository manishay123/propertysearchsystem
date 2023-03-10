package com.propertysearchsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.propertysearchsystem.model.User;
import com.propertysearchsystem.service.UserService;


@RestController
@RequestMapping()
public class UserController {

	UserService userService;
	
	 public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	 

	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome this endpoint is not secure";
	    }
/*
	@PostMapping("/user")
	  public ResponseEntity<User> createUser(@RequestBody User user) {
	  	return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	  }
	
	@PostMapping("/user")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
		*/
	    
		@PutMapping("/update/{id}")
		private User updateUser(@PathVariable int userId, @RequestBody User user) {
			
			return userService.updateUser(user, userId);
		}
		@GetMapping("/users")
		   public List<User> getAllusers(){
		      return userService.getAllUsers();
		   }
}
