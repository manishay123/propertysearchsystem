package com.propertysearchsystem.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String password;
	private String roleName;
}
