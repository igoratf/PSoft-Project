package com.example.preMatricula.entities;

import java.util.List;
import java.util.ArrayList;

public class Student {
	
	private String email;
	private Long registration;
	private Short period;
	private List<Discipline> enrolledDisciplines;
	
	public Student(String email, Long registration, Short period) {
		super();
		this.email = email;
		this.registration = registration;
		this.period = period;
		
		this.enrolledDisciplines = new ArrayList<>();
	}
	
	public void putDiscipline(Discipline discipline) {
		if (discipline == null) {
			throw new NullPointerException("Discipline não pode ser null.");
		}
		
		this.enrolledDisciplines.add(discipline);
	}

	public List<Discipline> getEnrolledDisciplines() {
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
