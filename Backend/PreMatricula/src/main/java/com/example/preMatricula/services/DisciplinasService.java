package com.example.preMatricula.services;

import java.util.List;
import java.util.Optional;

import com.example.preMatricula.entities.Disciplina;
import com.example.preMatricula.interfaces.DisciplinaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DisciplinasService {

    @Autowired
    private DisciplinaRepository disciplinas;

    public List<Disciplina> getDisciplinas() {
       
    	return this.disciplinas.findAll();
    }    

    public Optional<Disciplina> getDisciplinaById(String id) {

        return this.disciplinas.findById(id);
    }


    public ResponseEntity addDisciplina(Disciplina disciplina) {

        try {
            this.disciplinas.save(disciplina);

            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Disciplina cadastrada com sucesso!\"}");
        
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }

    public ResponseEntity updateDisciplina(Disciplina disciplina) {

        try {
            this.disciplinas.save(disciplina);
            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Update realizado com sucesso!\"}");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }

    public ResponseEntity deleteDisciplina(String id) {

        try {
            this.disciplinas.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"responseBody\": \"Disciplina removida com sucesso!\"}");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"responseBody\": \"" + e.getMessage()+ "\"}");
        }
    }

}