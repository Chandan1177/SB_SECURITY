package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/greet/anish")
	public String greet() {
		return "good Morning";
	}
	
	@GetMapping("/welcome")
	public String welcomr() {
		return "Welcome";
	}

}
