package com.example.preMatricula.controllers;

import java.util.Optional;
import java.io.IOException;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.services.CourseService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/course")
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping(path = "/disciplines")
	public Collection<Discipline> getAllDisciplines() throws IOException {
		
		return service.getDisciplines();
	}

	@GetMapping(path = "/disciplines/{code}")
	public Optional<Discipline> getById(@PathVariable(name = "code") Integer code) {
		
		return this.service.getDisciplineByCode(code);
	}
	
	@PutMapping(path = "/disciplines/put")
	public ResponseEntity<String> putDiscipline(@RequestBody Discipline discipline) {
				
		return this.service.putDiscipline(discipline);
	}
	
}
