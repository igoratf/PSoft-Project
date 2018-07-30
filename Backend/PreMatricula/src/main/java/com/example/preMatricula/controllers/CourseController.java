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
	public ResponseEntity<String> enroll(@RequestBody Enrollment enrollment) {
		
		return this.courseService.enroll(enrollment);
	}
	
	@PutMapping(path = "/student")
	public ResponseEntity<String> putStudent(@RequestBody Student student) {
		
		return this.courseService.putStudent(student);
	}
	
	@GetMapping(path = "/students")
	public List<Student> getStudents() {
		
		return this.courseService.getStudents();
	}
	
	@GetMapping(path = "/student")
	public @ResponseBody ResponseEntity<Optional<Student>> getStudent(@RequestHeader(name = "ID-TOKEN") String token) throws Exception {
		
		String id = this.userService.getUserIdFromIdToken(token);
		return this.courseService.getStudent(id);
	}
	
	// Lembrar de tentar salvar o banco inteiro a cada operação desse tipo!
	@DeleteMapping(path = "/students")
	public void deleteStudents() {
		
		this.courseService.deleteStudents();
	}
	
	@PutMapping(path = "/discipline")
	public ResponseEntity<String> putDiscipline(@RequestBody Discipline discipline) {
		
		return this.courseService.putDiscipline(discipline);
	}
	
	@GetMapping(path = "/discipline/{code}")
	public @ResponseBody ResponseEntity<Optional<Discipline>> getDiscipline(@PathVariable(name = "code") Integer code) {
		
		return this.courseService.getDiscipline(code);
	}
	
	@GetMapping(path = "/disciplines")
	public List<Discipline> getDisciplines() {
		
		return this.courseService.getDisciplines();
	}
	
	@DeleteMapping(path = "/disciplines")
	public void deleteDisciplines() {
		
		this.courseService.deleteDisciplines();
	}
	
}
