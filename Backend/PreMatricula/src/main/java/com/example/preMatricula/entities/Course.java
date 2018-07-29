package com.example.preMatricula.entities;

public class Course {

	public Course() {
		super();
	}

	/**
	 * Matricula um aluno específico em uma disciplina específica.
	 * 
	 * @param studentRegistration A matrícula do aluno.
	 * @param disciplineCode      O código da disciplina.
	 */
	public void enrollStudentInDiscipline(Student student, Discipline discipline) {	
		student.enrollInDiscipline(discipline.getCode());
		discipline.enrollStudent(student.getId());
	}
	
	public void unenrollStudentInDiscipline(Student student, Discipline discipline) {
		student.unenrollDiscipline(discipline.getCode());
		discipline.unenrollDiscipline(student.getId());
	}

}
