package com.example.preMatricula.entities;

import java.util.Set;

import com.example.preMatricula.enums.StudentCoursePlan;
import com.example.preMatricula.exceptions.StudentOnlyException;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Coordinator extends User {

	public Coordinator(String name) {
		super(name, "Coordinator");
	}

	@Override
	@JsonIgnore
	public Set<Integer> getEnrolledDisciplinesID() {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID) {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public Long getRegistration() {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public void setRegistration(Long registration) {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public Integer getSemester() {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public void setSemester(Integer semester) {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public StudentCoursePlan getCoursePlan() {
		throw new StudentOnlyException();
	}

	@Override
	@JsonIgnore
	public void setCoursePlan(StudentCoursePlan coursePlan) {
		throw new StudentOnlyException();
	}

	@Override
	public void unenrollFrom(Integer code) {
		throw new StudentOnlyException();
	}

}
