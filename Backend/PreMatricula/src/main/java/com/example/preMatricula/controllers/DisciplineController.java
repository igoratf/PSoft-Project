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
import com.example.preMatricula.services.DisciplineService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/disciplines")
public class DisciplineController {
	
	@Autowired
	private DisciplineService disciplineService;
	
	@PutMapping
	public @ResponseBody ResponseEntity<String> putDiscipline(
			@RequestHeader(name = "Authorization") String token, @RequestBody Discipline discipline) throws Exception {
		return this.disciplineService.putDiscipline(discipline, token);
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<List<Discipline>> getDisciplines(
			@RequestHeader(name = "Authorization") String token) throws Exception {
		return this.disciplineService.getDisciplines(token);
	}
	
}
