package com.example.preMatricula.entities;

import java.util.Set;

import org.springframework.data.annotation.Id;

import com.example.preMatricula.enums.StudentCoursePlan;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;

public class Student {
	
	@Id
	private String id;
	private String name;
	private String email;
	private StudentCoursePlan coursePlan;
	private Long registration;
	private Integer semester;
	private Set<Integer> enrolledDisciplinesID;
	
	public Student(String name, Long registration, Integer semester) {
		this.name = name;
		this.registration = registration;
		this.semester = semester;
		this.enrolledDisciplinesID = new HashSet<>();
	}
	
	public void unenrollFrom(Integer code) {
		this.enrolledDisciplinesID.remove(code);
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

	public StudentCoursePlan getCoursePlan() {
		return coursePlan;
	}

	public void setCoursePlan(StudentCoursePlan coursePlan) {
		this.coursePlan = coursePlan;
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
	public Set<Integer> getEnrolledDisciplinesID() {
	
		return this.enrolledDisciplinesID; 
 	}	
}
