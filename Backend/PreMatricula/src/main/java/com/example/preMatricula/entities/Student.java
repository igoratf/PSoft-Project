package com.example.preMatricula.entities;

import java.util.Set;
import java.util.HashSet;

public class Student {
	
	private String email;
	private Long registration;
	private Integer period;
	private Set<Long> enrolledDisciplinesID;
	
	public Student(String email, Long registration, Integer period) {
		super();
		this.email = email;
		this.registration = registration;
		this.period = period;
		this.enrolledDisciplinesID = new HashSet<>();
	}
	
	/**
	 * Matricula-se em uma disciplina.
	 * @param student A disciplina a se matricular.
	 * @return true se ainda não estava matriculado na disciplina e false caso contrário.
	 */
	public boolean enrollInDiscipline(Long disciplineID) {
		return this.enrolledDisciplinesID.add(disciplineID);
	}
	
	public void unenrollDiscipline(Long disciplineID) {
		this.enrolledDisciplinesID.remove(disciplineID);
	}

	public Set<Long> getEnrolledDisciplines() {
		return enrolledDisciplinesID;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getEmail() {
		return email;
	}
	
}
