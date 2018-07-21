package com.example.preMatricula.controllers;


import java.io.IOException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(path = "/disciplinas")
public class DisciplinasController {
	
	private DisciplinasService service = new DisciplinasService();
	
	@GetMapping
	public Collection<Disciplina> getAll() throws IOException{
		return service.getDisciplinas();
	}

	@GetMapping(path = "/{uid}")
	public Disciplina getById(@PathVariable(name = "uid") String uid) {
		return null;
    }
	
	
	// Tô deixando o esqueleto do put aqui, mas acho qe nao vai ser necessário,
	// imagino que nao vai ser necessário alterar uma disciplina.

	// @PutMapping("/{uid}")
	// public ResponseEntity<Disciplina> changeStatus(@PathVariable(name = "uid") String uid) throws IOException {
	// }


	// Da mesma forma do put, nao acho que vai ser necessário add uma disciplina,
	// pelo menos nao via http, as disciplinas já vão existir persistidas em um bd
	// @PostMapping 
	// public ResponseEntity<Disciplina> addUser(@RequestBody String token) throws IOException {
		
	// }

}
