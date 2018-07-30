package com.example.preMatricula.entities;

import java.util.Set;

import org.springframework.data.annotation.Id;

public abstract class User {

	@Id
	private String id;
	private String name;
	private String email;
	private String role;
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public abstract Set<Integer> getEnrolledDisciplinesID();

	public abstract void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID);

	public abstract Long getRegistration();

	public abstract void setRegistration(Long registration);

	public abstract Integer getSemester();

	public abstract void setSemester(Integer semester);
	
}
