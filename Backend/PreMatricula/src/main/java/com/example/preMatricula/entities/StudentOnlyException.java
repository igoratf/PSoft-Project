package com.example.preMatricula.entities;

public class StudentOnlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StudentOnlyException() {
		super("Operação permitida apenas para estudantes.");
	}

}
