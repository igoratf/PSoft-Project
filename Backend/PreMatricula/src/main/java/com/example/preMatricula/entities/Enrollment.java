package com.example.preMatricula.entities;

import java.util.List;

public class Enrollment {

	private String studentID;
	private List<Integer> disciplineCodes;
	
	public Enrollment(String studentID, List<Integer> disciplineCodes) {
		super();
		this.studentID = studentID;
		this.disciplineCodes = disciplineCodes;
	}

	public String getStudentID() {
		return studentID;
	}

	public List<Integer> getDisciplineCodes() {
		return disciplineCodes;
	}
	
}
