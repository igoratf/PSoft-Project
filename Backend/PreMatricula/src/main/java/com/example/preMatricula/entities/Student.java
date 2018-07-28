package com.example.preMatricula.entities;

import java.util.Set;
import java.util.HashSet;

public class Student {
	
	private String email;
	private Long registration;
	private Short period;
	private Set<Discipline> enrolledDisciplines;
	
	public Student(String email, Long registration, Short period) {
		super();
		this.email = email;
		this.registration = registration;
		this.period = period;
		this.enrolledDisciplines = new HashSet<>();
	}
	
	/**
	 * Matricula-se em uma disciplina.
	 * @param student A disciplina a se matricular.
	 * @return true se ainda não estava matriculado na disciplina e false caso contrário.
	 */
	public boolean enrollInDiscipline(Discipline discipline) {
		if (discipline == null) {
			throw new NullDisciplineException();
		}
		
		return this.enrolledDisciplines.add(discipline);
	}

	public Set<Discipline> getEnrolledDisciplines() {
		return enrolledDisciplines;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public Short getPeriod() {
		return period;
	}

	public void setPeriod(Short period) {
		this.period = period;
	}

	public String getEmail() {
		return email;
	}
	
}
