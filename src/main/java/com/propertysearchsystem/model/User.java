package com.propertysearchsystem.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotBlank(message = "UserName is mandatory")
	@Email
	private String userName;
	private String roleName;
	@NotBlank(message = "Password is mandatory")
	private String password;
}
