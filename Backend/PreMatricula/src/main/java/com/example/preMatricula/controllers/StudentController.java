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
import com.example.preMatricula.services.StudentService;
import com.example.preMatricula.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//@GetMapping
	//public @ResponseBody ResponseEntity<User> putStudent(
	//		@RequestHeader(name = "Authorization") String token) throws Exception {
	//	
	//	return this.studentService.putUser(token);
	//}
	
}
