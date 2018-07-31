package com.example.preMatricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.User;
import com.example.preMatricula.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public @ResponseBody ResponseEntity<User> getUser(
			@RequestHeader(name = "Authorization") String token) throws Exception {
		
		return this.userService.getUser(token);
	}
	
}
