package com.example.preMatricula.entities;

import java.util.Map;

public class Course {
	
	private Map<Long, Student> students;
	private Map<Long, Discipline> disciplines;
	
	public Course() {
		super();
	}
	
	public void enrollStudentInDiscipline(Student student, Discipline discipline) {
		if (student == null) {
			throw new NullPointerException("Estudent não pode ser null");
		}
		
		
		
	}
	
}
