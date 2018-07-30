package com.example.preMatricula.entities;

import java.util.Set;

import org.springframework.data.annotation.Id;

import java.util.HashSet;

public class Student {
	
	@Id
	private String id;
	private String email;
	private Long registration;
	private Integer semester;
	private Set<Integer> enrolledDisciplinesID;
	
	public Student(String id, String email, Long registration, Integer semester) {
		super();
		this.id = id;
		this.email = email;
		this.registration = registration;
		this.semester = semester;
		this.enrolledDisciplinesID = new HashSet<>();
	}

	public String getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setId(String userIdFromIdToken) {
		this.id = userIdFromIdToken;
	}
	
}
