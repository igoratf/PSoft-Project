package com.example.preMatricula.entities;

public class CoordinatorOnlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CoordinatorOnlyException() {
		super("Operação exclusiva ao coordenador.");
	}

}
