package com.example.preMatricula.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.services.CourseService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/course")
public class CourseController {

	@Autowired
	private CourseService service;

	@PutMapping(path = "/discipline")
	public ResponseEntity<String> putDiscipline(@RequestBody Discipline discipline) {
		
		return this.service.putDiscipline(discipline);
	}
	
	@GetMapping(path = "/discipline/{code}")
	public @ResponseBody ResponseEntity<Optional<Discipline>> getDiscipline(@PathVariable(name = "code") Integer code) {
		
		return this.service.getDiscipline(code);
	}
	
	@GetMapping(path = "/disciplines")
	public List<Discipline> getDisciplines() {
		
		return this.service.getDisciplines();
	}
	
	@DeleteMapping(path = "/disciplines")
	public void deleteDisciplines() {
		
		this.service.deleteDisciplines();
	}
	
}
