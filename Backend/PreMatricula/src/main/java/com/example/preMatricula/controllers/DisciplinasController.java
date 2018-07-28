package com.example.preMatricula.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.preMatricula.entities.Disciplina;
import com.example.preMatricula.services.DisciplinasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/disciplina")
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService service;

	@GetMapping
	public Collection<Disciplina> getAll() throws IOException {
		return service.getDisciplinas();
	}

	@GetMapping(path = "/{id}")
	public Optional<Disciplina> getById(@PathVariable(name = "id") String id) {
		return this.service.getDisciplinaById(id);
	}

	@PutMapping
	public ResponseEntity<Disciplina> updateDisciplina(@RequestBody Disciplina disciplina) {
		return this.service.updateDisciplina(disciplina);
	}

	@PostMapping
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody Disciplina disciplina) throws IOException {
		return this.service.addDisciplina(disciplina);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable(name = "id") String id) {

		return this.service.deleteDisciplina(id);

	}

	}
