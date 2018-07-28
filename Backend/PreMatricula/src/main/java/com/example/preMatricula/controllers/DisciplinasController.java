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
import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.services.DisciplinasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/disciplina")
public class DisciplinasController {

	@Autowired
	private DisciplinasService service;

	@GetMapping
	public Collection<Discipline> getAll() throws IOException {
		return service.getDisciplinas();
	}

	@GetMapping(path = "/{id}")
	public Optional<Discipline> getById(@PathVariable(name = "id") Long id) {
		return this.service.getDisciplinaById(id);
	}

	@PutMapping
	public ResponseEntity<String> updateDisciplina(@RequestBody Discipline disciplina) {
		return this.service.updateDisciplina(disciplina);
	}

	@PostMapping
	public ResponseEntity<String> addDisciplina(@RequestBody Discipline disciplina) throws IOException {
		return this.service.addDisciplina(disciplina);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDisciplina(@PathVariable(name = "id") Long id) {
		return this.service.deleteDisciplina(id);
	}

}
