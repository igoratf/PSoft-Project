package com.example.preMatricula.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Enrollment;
import com.example.preMatricula.entities.Student;
import com.example.preMatricula.entities.User;
import com.example.preMatricula.interfaces.UserRepository;

@Service
public class StudentService {

	@Autowired
	private UserRepository students;
	
	public void enrollStudentInDisciplines(Enrollment enrollment) {
		User student = this.students.findById(enrollment.getStudentID()).get();
		student.setEnrolledDisciplinesID( new HashSet<>(enrollment.getDisciplineCodes()));
	}
	
	public boolean putStudent(Student student) {
		boolean existed = this.students.existsById(student.getId());
		
		this.students.save(student);
		
		return existed;
	}

	public List<User> getStudents() {
		return this.students.findAll();
	}

	public boolean containsStudent(String id) {
		return this.students.existsById(id);
	}

	public Optional<User> getStudent(String id) {
		return this.students.findById(id);
	}

	public void deleteStudents() {
		this.students.deleteAll();
	}

	public boolean userExists(String uid) {
		return false;
	}

}
