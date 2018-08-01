package com.example.preMatricula.entities;

import java.util.Set;

import org.springframework.data.annotation.Id;

import com.example.preMatricula.enums.StudentCoursePlan;

public abstract class User {

	@Id
	private String id;
	private String name;
	private String email;
	private String role;
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.setRole(role);
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public abstract Set<Integer> getEnrolledDisciplinesID();

	public abstract void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID);

	public abstract Long getRegistration();

	public abstract void setRegistration(Long registration);

	public abstract Integer getSemester();

	public abstract void setSemester(Integer semester);

	public abstract StudentCoursePlan getCoursePlan();

	public abstract void setCoursePlan(StudentCoursePlan coursePlan);

	public abstract void unenrollFrom(Integer code);
	
}
