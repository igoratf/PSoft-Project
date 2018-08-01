package com.example.preMatricula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.entities.User;
import com.example.preMatricula.services.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PutMapping
	public @ResponseBody ResponseEntity<String> putStudent(@RequestHeader(name = "Authorization") String token, @RequestBody Student student)
			throws Exception {

		return this.studentService.putStudent(student, token);
	}

	@GetMapping
	public @ResponseBody ResponseEntity<List<User>> getDisciplines(
			@RequestHeader(name = "Authorization") String token) throws Exception {
		return this.studentService.getStudents(token);
	}
	
}
