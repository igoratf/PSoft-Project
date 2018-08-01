package com.example.preMatricula.entities;

import java.util.Set;

import com.example.preMatricula.enums.DisciplineCoursePlan;

import org.springframework.data.annotation.Id;

import java.util.HashSet;

public class Discipline {

	@Id
	private Integer code;
	private String name;
	private Integer credits;
	private Integer workload;
	private Integer semester;
	private DisciplineCoursePlan coursePlan;
	private Set<String> studentsEnrolledIDs;
	
	public Discipline(Integer code, Integer semester, String name, Integer credits, Integer workload, DisciplineCoursePlan coursePlan) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.workload = workload;
		this.semester = semester;
		this.coursePlan = coursePlan;
		this.studentsEnrolledIDs = new HashSet<>();
	}
	
	/**
	 * Matricula um novo estudante.
	 * @param studentID O identificador do estudante a ser matriculado.
	 * @return true se o estudante ainda não estava presente e false caso contrário.
	 */
	public boolean enrollStudent(String studentID) {	
		return studentsEnrolledIDs.add(studentID);
	}
	
	/**
	 * Desmatricula um estudante especificado pelo seu id.
	 * @param studentID O identificador do estudante a ser desmatriculado.
	 * @return true se tinha um estudante com esse id, false caso contrário.
	 */
	public boolean unenrollStudent(String studentID) {
		return this.studentsEnrolledIDs.remove(studentID);
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

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public DisciplineCoursePlan getCoursePlan() {
		return coursePlan;
	}

	public void setCoursePlan(DisciplineCoursePlan coursePlan) {
		this.coursePlan = coursePlan;
	}

	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public Set<String> getStudentsEnrolledIDs() {
		return studentsEnrolledIDs;
	}
	
}
