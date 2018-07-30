package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Enrollment;
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

	public List<Discipline> getDisciplines() {
		return this.disciplines.findAll();
	}

	public Optional<Discipline> getDiscipline(Integer code) {
		return this.disciplines.findById(code);
	}

	public boolean containsDiscipline(Integer code) {
		return this.disciplines.existsById(code);
	}

	public boolean containsAllDisciplines(List<Integer> codes) {
		Iterable<Discipline> found = this.disciplines.findAllById(codes);

		int size = 0;
		while (found.iterator().hasNext()) {
			found.iterator().next();
			size++;
		}

		return size == codes.size();
	}

	public void deleteDisciplines() {
		this.disciplines.deleteAll();
	}

	public void unenrollStudentFromAllDisciplines(String studentID) {
		this.disciplines.findAll().forEach(discipline -> discipline.unenrollStudent(studentID));
	}

	public void enrollStudentInDisciplines(Enrollment enrollment) {
		Iterable<Discipline> found = this.disciplines.findAllById(enrollment.getDisciplineCodes());
		found.forEach(discipline -> discipline.enrollStudent(enrollment.getStudentID()));
	}

}
