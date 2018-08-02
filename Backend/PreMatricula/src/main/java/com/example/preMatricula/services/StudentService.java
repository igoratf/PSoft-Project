package com.example.preMatricula.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.repositories.StudentRepository;
import com.google.firebase.auth.FirebaseToken;

@Service
public class StudentService {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentRepository students;

	public void enrollStudentInDisciplines(Enrollment enrollment) {
		Student student = this.students.findById(enrollment.getStudentID()).get();
		student.setEnrolledDisciplinesID(new HashSet<>(enrollment.getDisciplineCodes()));
		this.students.save(student);
	}
	
	public void unenrollStudentsFrom(Integer code) {
		this.students.findAll().forEach(student -> student.unenrollFrom(code));
	}

	public boolean putStudent(Student student) {
		boolean existed = this.students.existsById(student.getId());

		this.students.save(student);

		return existed;
	}

	public ResponseEntity<List<Student>> getStudents(String token) {
		try {
			if (!this.userService.isCoordinator(token)) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			
			return new ResponseEntity<>(this.students.findAll(), HttpStatus.OK);
			
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public boolean containsStudent(String id) {
		return this.students.existsById(id);
	}

	public Student getStudent(String id) {
		return this.students.findById(id).get();
	}

	public void deleteStudents() {
		this.students.deleteAll();
	}

	public boolean userExists(String uid) {
		return false;
	}

	public ResponseEntity<String> putStudent(Student student, String token) {
		try {
			if (this.userService.isCoordinator(token)) {
				return new ResponseEntity<>("Você não é um estudante.", HttpStatus.NOT_ACCEPTABLE);
			}
			
			FirebaseToken firebaseToken = this.userService.getFirebaseTokenFromIdToken(token);
			student.setId(firebaseToken.getUid());
			student.setEmail(firebaseToken.getEmail());
			student.setName(firebaseToken.getName());

			boolean existed = this.students.existsById(student.getId());
			
			this.students.save(student);

			if (existed) {
				return new ResponseEntity<>("Estudante atualizado(a)!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Estudante criado(a)!", HttpStatus.CREATED);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
