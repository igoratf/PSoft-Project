package com.example.preMatricula.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
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

	@PutMapping(path = "/discipline")
	public ResponseEntity<String> putDiscipline(@RequestBody Discipline discipline) {
		
		return service.putDiscipline(discipline);
	}
	
	/*@GetMapping(path = "/disciplines")
	public Collection<Discipline> getAllDisciplines() throws IOException {
		
		return service.getDisciplines();
	}*/
	
	
	
	
}
