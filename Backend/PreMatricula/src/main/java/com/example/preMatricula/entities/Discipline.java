package com.example.preMatricula.entities;

import java.util.Set;

import org.springframework.data.annotation.Id;

import java.util.HashSet;

public class Discipline {

	@Id
	private Integer code;
	private String name;
	private Integer credits;
	private Integer workload;
	private Grade grade;
	private Set<String> studentsEnrolledEmails;
	
	public Discipline(Integer code, String name, Integer credits, Integer workload, Grade grade) {
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
	
	/**
	 * Desmatricula um estudante especificado pelo seu id.
	 * @param studentId O id do estudante a ser desmatriculado.
	 * @return true se tinha um estudante com esse id, false caso contrário.
	 */
	public boolean unenrollDiscipline(String studentId) {
		return this.studentsEnrolledEmails.remove(studentId);
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

	public Integer getCode() {
		return code;
	}

	public Set<String> getStudentsEnrolled() {
		return studentsEnrolledEmails;
	}
	
}
