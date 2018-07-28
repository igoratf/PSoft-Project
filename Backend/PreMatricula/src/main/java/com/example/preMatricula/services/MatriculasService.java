package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import com.example.preMatricula.entities.Student;
import com.example.preMatricula.interfaces.MatriculaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MatriculasService {

	@Autowired
	private MatriculaRepository matriculas;

	public List<Student> getMatriculas() {
		return this.matriculas.findAll();
	}

	public Optional<Student> getMatriculaById(Long id) {
		return this.matriculas.findById(id);
	}

	public ResponseEntity<String> addMatricula(Student matricula) {
		try {
			this.matriculas.save(matricula);

			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"responseBody\": \"matricula cadastrada com sucesso!\"}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage() + "\"}");
		}
	}

	public ResponseEntity<String> updateMatricula(Student matricula) {
		try {
			this.matriculas.save(matricula);
			return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Update realizado com sucesso!\"}");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage() + "\"}");
		}
	}

	public ResponseEntity<String> deleteMatricula(Long id) {
		try {
			this.matriculas.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"matricula removida com sucesso!\"}");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage() + "\"}");
		}
	}

}