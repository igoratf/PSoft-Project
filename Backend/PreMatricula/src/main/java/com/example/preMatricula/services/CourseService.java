package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.interfaces.StudentRepository;

@Service
public class CourseService {

	@Autowired
	private StudentRepository students;

	@Autowired
	private DisciplineService disciplineManager;

	public ResponseEntity<String> putDiscipline(Discipline discipline) {
		try {
			if (this.disciplineManager.putDiscipline(discipline)) {
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

	public List<Student> getStudents() {
		return this.students.findAll();
	}

	public Optional<Student> getStudentByID(String studentID) {

		return this.students.findById(studentID);
	}

	/*
	 * public ResponseEntity<String> deleteDiscipline(Integer code) { try { boolean
	 * exists = this.disciplines.existsById(code);
	 * 
	 * if (exists) { this.disciplines.deleteById(code);
	 * 
	 * return new ResponseEntity<>((new JSONObject()).put("responseBody",
	 * "Disciplina deletada!").toString(), HttpStatus.OK); } else { return new
	 * ResponseEntity<>( (new JSONObject()).put("responseBody",
	 * "A disciplina não existe.").toString(), HttpStatus.CREATED); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}",
	 * HttpStatus.BAD_REQUEST); } }
	 */

	public ResponseEntity<String> addStudent(Student student) {
		try {
			boolean existed = this.students.existsById(student.getId());

			this.students.save(student);

			if (existed) {
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

}
