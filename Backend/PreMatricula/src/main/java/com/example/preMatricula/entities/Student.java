package com.example.preMatricula.entities;

import java.util.Set;

import java.util.HashSet;

public class Student extends User {
	
	private Long registration;
	private Integer semester;
	private Set<Integer> enrolledDisciplinesID;
	
	public Student(String name, Long registration, Integer semester) {
		super(name, "Student");
		this.registration = registration;
		this.semester = semester;
		this.enrolledDisciplinesID = new HashSet<>();
	}

	public Set<Integer> getEnrolledDisciplinesID() {
		return enrolledDisciplinesID;
	}

	public void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID) {
		this.enrolledDisciplinesID = enrolledDisciplinesID;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	
}
