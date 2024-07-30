package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passpordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	public UserDetailsService getDetailsService() {
//		return new CustomUserDetailsService();
//	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passpordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    
	    http.csrf().disable()
	        .authorizeHttpRequests()
	        .requestMatchers("/welcome").permitAll() // Accessible to everyone
	        .requestMatchers("/admin/**").hasRole("ADMIN") // Accessible only to users with the role "ADMIN"
	        .requestMatchers("/greet/**").hasRole("USER")   // Accessible only to users with the role "USER"
	        .anyRequest().authenticated()                 // All other requests require authentication
	        .and().formLogin()                             // Enables form-based login
	        ;                                 // Allow everyone to access the login page
	    
	    return http.build();
	}

}
