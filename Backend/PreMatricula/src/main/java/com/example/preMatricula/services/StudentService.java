package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Student;
import com.example.preMatricula.interfaces.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository students;
	
	public boolean putStudent(Student student) {
		boolean existed = this.students.existsById(student.getId());
		
		this.students.save(student);
		
		return existed;
	}

	public List<Student> getStudents() {
		return this.students.findAll();
	}

	public boolean containsStudent(String id) {
		return this.students.existsById(id);
	}

	public Optional<Student> getStudent(String id) {
		return this.students.findById(id);
	}

	public void deleteStudents() {
		this.students.deleteAll();
	}

}
