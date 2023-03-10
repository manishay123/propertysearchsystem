package com.propertysearchsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="user_id")
		private int userId;
		
		@Column(name="user_name")
		private String userName;
			
		@Column(name="password")
		private String password;
		
		@Column(name="role")
		private String role;
}
