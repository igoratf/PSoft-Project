package com.example.preMatricula.entities;

public class NullDisciplineException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NullDisciplineException() {
		super("Discipline não pode ser null.");
	}

}
