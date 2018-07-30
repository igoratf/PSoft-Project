package com.example.preMatricula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.interfaces.DisciplinaRepository;

@Service
public class DisciplineService {

	@Autowired
	private DisciplinaRepository disciplines;
	
	public boolean putDiscipline(Discipline discipline) {
		boolean existed = this.disciplines.existsById(discipline.getCode());
		
		this.disciplines.save(discipline);
		
		return existed;
	}
	
}
