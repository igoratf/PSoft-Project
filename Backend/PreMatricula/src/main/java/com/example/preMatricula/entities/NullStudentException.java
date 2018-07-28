package com.example.preMatricula.entities;

public class NullStudentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NullStudentException() {
		super("Student não pode ser null.");
	}
	
}
