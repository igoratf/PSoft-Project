package com.example.preMatricula.controllers;

import java.util.Optional;
import java.io.IOException;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public Collection<Discipline> getAll() throws IOException {
		
		return service.getDisciplines();
	}

	@GetMapping(path = "/{code}")
	public Optional<Discipline> getById(@PathVariable(name = "code") Integer code) {
		
		return this.service.getDisciplineByCode(code);
	}
	
}
