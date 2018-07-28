package com.example.preMatricula.controllers;

import java.io.IOException;
import java.util.List;
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
import com.example.preMatricula.entities.Matricula;
import com.example.preMatricula.services.MatriculasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/matricula")
public class MatriculaController {
	
	@Autowired
	private MatriculasService service;

	@GetMapping
	public List<Matricula> getAll() throws IOException {
		return service.getMatriculas();
	}

	@GetMapping(path = "/{id}")
	public Optional<Matricula> getById(@PathVariable(name = "id") String id) {
		return this.service.getMatriculaById(id);
	}

	@PutMapping
	public ResponseEntity<Disciplina> updateMatricula(@RequestBody Matricula matricula) {
		return this.service.updateMatricula(matricula);
	}

	@PostMapping
	public ResponseEntity<Disciplina> addMatricula(@RequestBody Matricula matricula) throws IOException {
		return this.service.addMatricula(matricula);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Matricula> deleteDisciplina(@PathVariable(name = "id") String id) {

		return this.service.deleteMatricula(id);

	}

	}
