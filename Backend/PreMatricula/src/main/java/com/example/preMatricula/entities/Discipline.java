package com.example.preMatricula.entities;

import java.util.Set;
import java.util.HashSet;

public class Discipline {

	private String name;
	private Long code;
	private Integer credits;
	private Integer workload;
	private Grade grade;
	private Set<String> studentsEnrolledEmails;
	
	public Discipline(String name, Long code, Integer credits, Integer workload, Grade grade) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.workload = workload;
		this.grade = grade;
		this.studentsEnrolledEmails = new HashSet<>();
	}
	
	/**
	 * Matricula um novo estudante.
	 * @param student O estudante a ser matriculado.
	 * @return true se o estudante ainda não estava presente e false caso contrário.
	 */
	public boolean enrollStudent(String studentEmail) {	
		return studentsEnrolledEmails.add(studentEmail);
	}
	
	public void unenrollDiscipline(String studentEmail) {
		this.studentsEnrolledEmails.remove(studentEmail);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
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

	public Set<String> getStudentsEnrolled() {
		return studentsEnrolledEmails;
	}
	
}
