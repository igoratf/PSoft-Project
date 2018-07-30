package com.example.preMatricula.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.preMatricula.entities.Student;
import com.example.preMatricula.interfaces.StudentRepository;

public class StudentService {

	@Autowired
	private StudentRepository students;
	
	public boolean putStudent(Student student) {
		boolean existed = this.students.existsById(student.getId());
		
		this.students.save(student);
		
		return existed;
	}

}
