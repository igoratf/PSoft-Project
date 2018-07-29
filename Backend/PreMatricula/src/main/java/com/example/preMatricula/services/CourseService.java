package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.interfaces.DisciplinaRepository;
import com.example.preMatricula.interfaces.StudentRepository;

@Service
public class CourseService {

	@SuppressWarnings("unused")
	private StudentRepository students;

    @Autowired
    private DisciplinaRepository disciplines;

    public List<Discipline> getDisciplinas() {
       
    	return this.disciplines.findAll();
    }    

    public Optional<Discipline> getDisciplinaById(Long id) {

        return this.disciplines.findById(id);
    }


    public ResponseEntity<String> addDisciplina(Discipline discipline) {

        try {
            this.disciplines.save(discipline);

            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Disciplina cadastrada com sucesso!\"}");
        
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }

    public ResponseEntity<String> updateDisciplina(Discipline disciplina) {

        try {
            this.disciplines.save(disciplina);
            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Update realizado com sucesso!\"}");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }

    public ResponseEntity<String> deleteDisciplina(Long id) {
        try {
            this.disciplines.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Disciplina removida com sucesso!\"}");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }
    
}
