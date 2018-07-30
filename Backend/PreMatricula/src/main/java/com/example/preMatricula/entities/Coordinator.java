package com.example.preMatricula.entities;

import java.util.Set;

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

}
