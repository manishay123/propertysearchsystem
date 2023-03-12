package com.propertysearchsystem.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;
}
