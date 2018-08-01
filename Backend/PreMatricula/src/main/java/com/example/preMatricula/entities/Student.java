package com.example.preMatricula.entities;

import java.util.Set;

import com.example.preMatricula.enums.StudentCoursePlan;

import java.util.HashSet;

public class Student extends User {
	
	private StudentCoursePlan coursePlan;
	private Long registration;
	private Integer semester;
	private Set<Integer> enrolledDisciplinesID;
	
	public Student(String name, Long registration, Integer semester) {
		super(name, "Student");
		this.registration = registration;
		this.semester = semester;
		this.enrolledDisciplinesID = new HashSet<>();
	}
	
	private Integer computeSemester() {		
		return -1;
	}
	
	@Override
	public void unenrollFrom(Integer code) {
		this.enrolledDisciplinesID.remove(code);
	}

	@Override
	public Set<Integer> getEnrolledDisciplinesID() {
		return enrolledDisciplinesID;
	}

	@Override
	public void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID) {
		this.enrolledDisciplinesID = enrolledDisciplinesID;
	}

	@Override
	public Long getRegistration() {
		return registration;
	}

	@Override
	public void setRegistration(Long registration) {
		//this.semester = 
		this.registration = registration;
	}

	@Override
	public Integer getSemester() {
		return semester;
	}

	@Override
	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	@Override
	public StudentCoursePlan getCoursePlan() {
		return coursePlan;
	}

	@Override
	public void setCoursePlan(StudentCoursePlan coursePlan) {
		this.coursePlan = coursePlan;
	}
	
}
