package com.example.preMatricula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.repositories.DisciplinaRepository;

@Service
public class DisciplineService {

	@Autowired
	private DisciplinaRepository disciplines;

	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;

	public ResponseEntity<String> putDiscipline(Discipline discipline, String token) {
		try {
			if (!this.userService.isCoordinator(token)) {
				return new ResponseEntity<String>("Você precisa ser o coordenador para poder colocar uma nova disciplina.", HttpStatus.UNAUTHORIZED);
			}
			
			System.out.println(discipline.getCode());
			System.out.println(discipline.getCredits());
			System.out.println(discipline.getName());

			boolean existed = this.disciplines.existsById(discipline.getCode());

			this.disciplines.save(discipline);

			if (existed) {
				return new ResponseEntity<>("Disciplina atualizada!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Disciplina criada!", HttpStatus.CREATED);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Discipline>> getDisciplines(String token) {
		try {
			if (!this.userService.isAuthenticated(token)) {
				return new ResponseEntity<>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
			}

			return new ResponseEntity<>(this.disciplines.findAll(), HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<List<Discipline>>(HttpStatus.BAD_REQUEST);
		}
	}

	public boolean containsDiscipline(Integer code) {
		return this.disciplines.existsById(code);
	}

	public boolean containsAllDisciplines(List<Integer> codes) {
		Iterable<Discipline> found = this.disciplines.findAllById(codes);

		int size = 0;
		while (found.iterator().hasNext()) {
			found.iterator().next();
			size++;
		}

		return size == codes.size();
	}

	public void unenrollStudentFromAllDisciplines(String studentID) {
		this.disciplines.findAll().forEach(discipline -> {
			discipline.unenrollStudent(studentID);
			this.disciplines.save(discipline);
		});
	}

	public void enrollStudentInDisciplines(Enrollment enrollment) {
		Iterable<Discipline> found = this.disciplines.findAllById(enrollment.getDisciplineCodes());
		found.forEach(discipline -> discipline.enrollStudent(enrollment.getStudentID()));
		this.disciplines.saveAll(found);
	}

	public Integer computeTotalCredits(List<Integer> codes) {
		Iterable<Discipline> found = this.disciplines.findAllById(codes);

		int sumCredits = 0;
		for (Discipline discipline : found) {
			sumCredits += discipline.getCredits();
		}

		return sumCredits;
	}

	public ResponseEntity<String> deleteDiscipline(Integer code, String token) {
		try {
			if (!this.userService.isCoordinator(token)) {
				return new ResponseEntity<String>("Você precisa ser o coordenador para poder deletar uma disciplina.", HttpStatus.UNAUTHORIZED);
			}
			
			if (!this.disciplines.existsById(code)) {
				return new ResponseEntity<String>("O código de disciplina não foi encontrado.", HttpStatus.NOT_FOUND);
			}
			
			this.studentService.unenrollStudentsFrom(code);
			this.disciplines.deleteById(code);
			
			return new ResponseEntity<String>("Disciplina removida com sucesso!", HttpStatus.OK); 
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
