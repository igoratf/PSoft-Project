package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.entities.Student;

@Service
public class CourseService {

	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private StudentService studentService;
	
	
	public ResponseEntity<String> enroll(Enrollment enrollment) {
		try {
			if (!this.studentService.containsStudent(enrollment.getStudentID())) {
				return new ResponseEntity<>((new JSONObject()).put("responseBody", "Estudante não encontrado.").toString(), HttpStatus.BAD_REQUEST);
			}
			
			boolean hasError = false;
			JSONObject errors = new JSONObject();
			errors.put("responseBody", "Uma ou mais disciplinas não foram encontradas.");
			for (Integer code : enrollment.getDisciplineCodes()) {
				if (!this.disciplineService.containsDiscipline(code)) {
					hasError = true;
					errors.accumulate("notFoundDisciplines", code);
				}
			}
			
			if (hasError) {
				return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
			}
			
			if (!this.validateCredits(enrollment.getDisciplineCodes())) {
				return new ResponseEntity<>("Quantidade inválida de créditos.", HttpStatus.BAD_REQUEST);
			}
			
			this.disciplineService.unenrollStudentFromAllDisciplines(enrollment.getStudentID());
			this.disciplineService.enrollStudentInDisciplines(enrollment);
			
			this.studentService.enrollStudentInDisciplines(enrollment);
						
		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> putStudent(Student student) {
		try {
			if (this.studentService.putStudent(student)) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Estudante atualizado(a) com sucesso!").toString(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Estudante criado(a) com sucesso!").toString(),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	}
	
	public ResponseEntity<Optional<Student>> getStudent(String id) {
		if (this.studentService.containsStudent(id)) {
			return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void deleteStudents() {
		this.studentService.deleteStudents();
	}

	public ResponseEntity<String> putDiscipline(Discipline discipline) {
		try {
			if (this.disciplineService.putDiscipline(discipline)) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina atualizada com sucesso!").toString(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina criada com sucesso!").toString(),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}

	public List<Discipline> getDisciplines() {
		return this.disciplineService.getDisciplines();
	}

	public ResponseEntity<Optional<Discipline>> getDiscipline(Integer code) {
		if (this.disciplineService.containsDiscipline(code)) {
			return new ResponseEntity<>(this.disciplineService.getDiscipline(code), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteDisciplines() {
		this.disciplineService.deleteDisciplines();
	}
	
	private boolean validateCredits(List<Integer> disciplines) {
		int sumCredits = this.disciplineService.computeTotalCredits(disciplines);
		
		final int minCredits = 16;
		final int maxCredits = 24;
		
		return (minCredits >= sumCredits && sumCredits <= maxCredits);
	}
	
}
