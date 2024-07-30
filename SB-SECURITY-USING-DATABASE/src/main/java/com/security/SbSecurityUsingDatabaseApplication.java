package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.security"})
public class SbSecurityUsingDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSecurityUsingDatabaseApplication.class, args);
		
//		System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}

}
