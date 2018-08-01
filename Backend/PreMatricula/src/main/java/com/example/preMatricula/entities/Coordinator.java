package com.example.preMatricula.entities;

import java.util.Set;

import com.example.preMatricula.enums.StudentCoursePlan;
import com.example.preMatricula.exceptions.StudentOnlyException;

public class Coordinator extends User {

	public Coordinator(String name) {
		super(name, "Coordinator");
	}

	@Override
	public Set<Integer> getEnrolledDisciplinesID() {
		throw new StudentOnlyException();
	}

	@Override
	public void setEnrolledDisciplinesID(Set<Integer> enrolledDisciplinesID) {
		throw new StudentOnlyException();
	}

	@Override
	public Long getRegistration() {
		throw new StudentOnlyException();
	}

	@Override
	public void setRegistration(Long registration) {
		throw new StudentOnlyException();
	}

	@Override
	public Integer getSemester() {
		throw new StudentOnlyException();
	}

	@Override
	public void setSemester(Integer semester) {
		throw new StudentOnlyException();
	}

	@Override
	public StudentCoursePlan getCoursePlan() {
		throw new StudentOnlyException();
	}

	@Override
	public void setCoursePlan(StudentCoursePlan coursePlan) {
		throw new StudentOnlyException();
	}

}
