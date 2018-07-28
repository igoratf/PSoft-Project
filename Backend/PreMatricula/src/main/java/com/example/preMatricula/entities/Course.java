package com.example.preMatricula.entities;

import java.util.HashMap;
import java.util.Map;

public class Course {

	private Map<Long, Student> students;
	private Map<Long, Discipline> disciplines;

	public Course() {
		super();

		this.students = new HashMap<>();
		this.disciplines = new HashMap<>();
	}

	/**
	 * Matricula um aluno específico em uma disciplina específica.
	 * 
	 * @param studentRegistration A matrícula do aluno.
	 * @param disciplineCode      O código da disciplina.
	 */
	public void enrollStudentInDiscipline(Long studentRegistration, Long disciplineCode) {
		Student student = this.students.get(studentRegistration);
		Discipline discipline = this.disciplines.get(disciplineCode);

		if (student == null) {
			throw new IllegalArgumentException(
					"O estudante de matrícula " + studentRegistration + " não existe no sistema.");
		} else if (discipline == null) {
			throw new IllegalArgumentException("A disciplina de código " + disciplineCode + " não existe no sistema.");
		}

		student.enrollInDiscipline(discipline);
		discipline.enrollStudent(student);
	}

}
