package com.example.preMatricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.User;
import com.example.preMatricula.services.DisciplineService;
import com.example.preMatricula.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/disciplines")
public class DisciplineController {
	
	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private UserService userService;
	
	//@PutMapping
	//public @ResponseBody ResponseEntity<User> putDiscipline(
	//		@RequestHeader(name = "Authorization") String token) throws Exception {
	//	return this.disciplineService.getUser(token);
	//}
	
	
	
}
