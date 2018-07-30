package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;

@Service
public class CourseService {

	@Autowired
	private DisciplineService disciplineManager;

	public ResponseEntity<String> putDiscipline(Discipline discipline) {
		try {
			if (this.disciplineManager.putDiscipline(discipline)) {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina atualizada com sucesso!").toString(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						(new JSONObject()).put("responseBody", "Disciplina criada com sucesso!").toString(),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("{" + "responseBody:" + e.getMessage() + "}", HttpStatus.BAD_REQUEST);
		}
	}

	public List<Discipline> getDisciplines() {
		return this.disciplineManager.getDisciplines();
	}

	public ResponseEntity<Optional<Discipline>> getDiscipline(Integer code) {
		if (this.disciplineManager.containsDiscipline(code)) {
			return new ResponseEntity<>(this.disciplineManager.getDiscipline(code), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteDisciplines() {
		this.disciplineManager.deleteDisciplines();
	}

}
