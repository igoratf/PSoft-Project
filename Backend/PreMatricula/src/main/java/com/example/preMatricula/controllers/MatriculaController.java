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
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.services.MatriculasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/matricula")
public class MatriculaController {

	@Autowired
	private MatriculasService service;

	@GetMapping
	public List<Student> getAll() throws IOException {
		return service.getMatriculas();
	}

	@GetMapping(path = "/{id}")
	public Optional<Student> getById(@PathVariable(name = "id") Long id) {
		return this.service.getMatriculaById(id);
	}

	@PutMapping
	public ResponseEntity<String> updateMatricula(@RequestBody Student matricula) {
		return this.service.updateMatricula(matricula);
	}

	@PostMapping
	public ResponseEntity<String> addMatricula(@RequestBody Student matricula) throws IOException {
		return this.service.addMatricula(matricula);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDisciplina(@PathVariable(name = "id") Long id) {

		return this.service.deleteMatricula(id);

	}

}
