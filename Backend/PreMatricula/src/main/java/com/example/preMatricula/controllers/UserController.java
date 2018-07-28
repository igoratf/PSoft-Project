package com.example.preMatricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.services.UserService;

@CrossOrigin(origins = "*")
@RequestMapping(path = "/user/save")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public void save(@RequestHeader(value="ID-TOKEN") String idToken) throws Exception {
		service.saveUser(idToken);
	}

}