package com.example.preMatricula.entities;

import java.util.Set;
import java.util.HashSet;

public class Discipline {

	private String name;
	private Long code;
	private Short credits;
	private Short workload;
	private Grade grade;
	private Set<Student> studentsEnrolled;
	
	public Discipline(String name, Long code, Short credits, Short workload, Grade grade) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.workload = workload;
		this.grade = grade;
		this.studentsEnrolled = new HashSet<>();
	}
	
	/**
	 * Matricula um novo estudante.
	 * @param student O estudante a ser matriculado.
	 * @return true se o estudante ainda não estava presente e false caso contrário.
	 */
	public boolean enrollStudent(Student student) {
		if (student == null) {
			throw new NullStudentException();
		}
				
		return studentsEnrolled.add(student);
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

	public Set<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	
}
