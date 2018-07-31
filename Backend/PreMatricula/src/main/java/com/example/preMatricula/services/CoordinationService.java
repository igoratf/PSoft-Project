package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.entities.User;

@Service
public class CoordinationService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private DisciplineService disciplineService;
	
	public ResponseEntity<String> enroll(List<Integer> disciplineCodes, String token) {
		try  {
			String uid = this.userService.getUserIdFromIdToken(token);
			
			return this.enroll(new Enrollment(uid, disciplineCodes));
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	private ResponseEntity<String> enroll(Enrollment enrollment) {
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
			
			return new ResponseEntity<>("Estudante matriculado com sucesso!", HttpStatus.ACCEPTED);
			
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
	
	public List<User> getStudents() {
		return this.studentService.getStudents();
	}
	
	public ResponseEntity<Optional<User>> getStudent(String id) {
		if (this.studentService.containsStudent(id)) {
			return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private boolean validateCredits(List<Integer> disciplines) {
		int sumCredits = this.disciplineService.computeTotalCredits(disciplines);
		
		final int minCredits = 16;
		final int maxCredits = 24;
		
		return (minCredits >= sumCredits && sumCredits <= maxCredits);
	}
	
	public boolean containsStudent(String id) {
		return this.studentService.containsStudent(id);
	}

}
