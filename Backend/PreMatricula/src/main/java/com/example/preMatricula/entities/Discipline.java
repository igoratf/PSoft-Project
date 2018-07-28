package com.example.preMatricula.entities;

import java.util.List;

public class Discipline {

	private String name;
	private Long code;
	private Short credits;
	private Short workload;
	private Grade grade;
	private List<Student> studentsEnrolled;
	
	public Discipline(String name, Long code, Short credits, Short workload, Grade grade) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.workload = workload;
		this.grade = grade;
	}
	
	public void putStudent(Student student) {
		if (student == null) {
			throw new NullPointerException("Student não pode ser null.");
		}
		
		studentsEnrolled.add(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getCredits() {
		return credits;
	}

	public void setCredits(Short credits) {
		this.credits = credits;
	}

	public Short getWorkload() {
		return workload;
	}

	public void setWorkload(Short workload) {
		this.workload = workload;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Long getCode() {
		return code;
	}

	public List<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	
}
