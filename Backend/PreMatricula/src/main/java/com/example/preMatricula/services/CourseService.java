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
import com.example.preMatricula.interfaces.DisciplinaRepository;
import com.example.preMatricula.interfaces.StudentRepository;

@Service
public class CourseService {

	@Autowired
	private StudentRepository students;

	@Autowired
	private DisciplinaRepository disciplines;

	public List<Student> getStudents() {
		return this.students.findAll();
	}

	public List<Discipline> getDisciplines() {

		return this.disciplines.findAll();
	}

	public Optional<Student> getStudentByID(String studentID) {

		return this.students.findById(studentID);
	}

	public Optional<Discipline> getDisciplineByCode(Integer code) {

		return this.disciplines.findById(code);
	}

	public ResponseEntity<JSONObject> putDiscipline(Discipline discipline) {
		try {
			boolean existed = this.disciplines.existsById(discipline.getCode());

			this.disciplines.save(discipline);

			if (existed) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina atualizada com sucesso!"), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina cadastrada com sucesso!"), HttpStatus.CREATED);
			}
			
		} catch (Exception e) {

			return new ResponseEntity<>((new JSONObject()).put("responseBody", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<JSONObject> addStudent(Student student) {
		try {
			boolean existed = this.students.existsById(student.getId());
			
			this.students.save(student);

			if (existed) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Estudante atualizado(a) com sucesso!"), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Estudante criado(a) com sucesso!"), HttpStatus.CREATED);
			}
			
		} catch (Exception e) {

			return new ResponseEntity<>((new JSONObject()).put("responseBody", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
