package com.example.preMatricula.services;

import java.util.LinkedList;
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

	public ResponseEntity<String> putDiscipline(Discipline discipline) {
		try {
			boolean existed = this.disciplines.existsById(discipline.getCode());

			this.disciplines.save(discipline);

			if (existed) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina atualizada com sucesso!").toString(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina cadastrada com sucesso!").toString(),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> putDisciplines(List<Discipline> disciplines) {
		try {
			List<Integer> created = new LinkedList<>();
			List<Integer> updated = new LinkedList<>();
			for (Discipline discipline : disciplines) {
				if (this.disciplines.existsById(discipline.getCode())) {
					updated.add(discipline.getCode());
				} else {
					created.add(discipline.getCode());
				}
			}

			this.disciplines.saveAll(disciplines);

			return new ResponseEntity<>((new JSONObject()).put("created", created).put("updated", updated).toString(),
					HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}

	/*public ResponseEntity<String> deleteDiscipline(Integer code) {
		try {
			boolean exists = this.disciplines.existsById(code);

			if (exists) {
				this.disciplines.deleteById(code);

				return new ResponseEntity<>((new JSONObject()).put("responseBody", "Disciplina deletada!").toString(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "A disciplina não existe.").toString(),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}*/

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
