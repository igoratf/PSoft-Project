package com.example.preMatricula.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.services.CourseService;
import com.example.preMatricula.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@PutMapping(path = "/enroll")
	public ResponseEntity<String> enroll(@RequestBody Enrollment enrollment,
			@RequestHeader(name = "Authorization") String token) throws Exception {

		if (userService.isAuthenticated(token))
			return this.courseService.enroll(enrollment);
		return null;
	}

	@PutMapping(path = "/student")
	public ResponseEntity<String> putStudent(@RequestBody Student student,
			@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token)) {
			String uid = userService.getUserIdFromIdToken(token.split(" ")[1]);
			student.setId(uid);
			return this.courseService.putStudent(student);
		}
		return null;
	}

	@GetMapping(path = "/students")
	public List<Student> getStudents(@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token))
			return this.courseService.getStudents();
		return null;
	}

	@GetMapping(path = "/student")
	public @ResponseBody ResponseEntity<Optional<Student>> getStudent(
			@RequestHeader(name = "Authorization") String token) throws Exception {

		if (userService.isAuthenticated(token)) {
			String id = this.userService.getUserIdFromIdToken(token);
			return this.courseService.getStudent(id);
		}
		return null;
	}

	// Lembrar de tentar salvar o banco inteiro a cada operação desse tipo!
	@DeleteMapping(path = "/students")
	public void deleteStudents(@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token))
			this.courseService.deleteStudents();
	}

	@PutMapping(path = "/discipline")
	public ResponseEntity<String> putDiscipline(@RequestBody Discipline discipline,
			@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token))
			return this.courseService.putDiscipline(discipline);
		return null;
	}

	@GetMapping(path = "/discipline/{code}")
	public @ResponseBody ResponseEntity<Optional<Discipline>> getDiscipline(@PathVariable(name = "code") Integer code,
			@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token))
			return this.courseService.getDiscipline(code);
		return null;
	}

	@GetMapping(path = "/disciplines")
	public List<Discipline> getDisciplines(@RequestHeader(name = "Authorization") String token) throws Exception {
		if (userService.isAuthenticated(token))
			return this.courseService.getDisciplines();
		return null;
	}

	@DeleteMapping(path = "/disciplines")
	public void deleteDisciplines(@RequestHeader(name = "Authorization") String token) throws Exception {

		if (userService.isAuthenticated(token))
			this.courseService.deleteDisciplines();

	}

	@GetMapping(path = "/login")
	public boolean userExist(@RequestHeader(name = "Authorization") String token) throws Exception {

		if (userService.isAuthenticated(token)) {
			String uid = userService.getUserIdFromIdToken(token.split(" ")[1]);
			return this.courseService.containsStudent(uid);
		}

		return false;

	}

}
