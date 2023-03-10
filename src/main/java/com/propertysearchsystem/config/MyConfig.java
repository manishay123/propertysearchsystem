package com.propertysearchsystem.config;

import org.hibernate.tuple.InMemoryValueGenerationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
public class MyConfig {


/*
	@Bean
	public InMemoryUserDetailsManager  UserDetailsService() {
		UserDetails normalUser = User.withUsername("manisha").password("password").roles("USER").build();
		UserDetails adminUser = User.withUsername("mani").password("password").roles("ADMIN").build();
		return new  InMemoryUserDetailsManager(normalUser, adminUser);
		
		//return new UserDetailServiceImpl();
	}*/

	@Bean
	UserDetailsService  getUserDetailsService() {
		UserDetails normalUser = User.withUsername("manisha").password(passwordEncoder().encode("password")).roles("USER").build();
		UserDetails adminUser = User.withUsername("mani").password(passwordEncoder().encode("password")).roles("ADMIN").build();
		return new  InMemoryUserDetailsManager(normalUser, adminUser);
		
		//return new UserDetailServiceImpl();
	}
	
	
/*	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	return daoAuthenticationProvider;
	}
*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/users").hasAnyRole("USER")
		.requestMatchers("/welcome").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and().httpBasic();
		
		return httpSecurity.build();
	}

	
	
	
	
	
	
	
	

	
	
	

}
