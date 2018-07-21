package com.example.preMatricula.services;

import java.util.Collection;
import java.util.HashMap;

import com.example.preMatricula.entities.Disciplina;

import org.springframework.stereotype.Service;

@Service

public class DisciplinasService {

    private HashMap<Integer, Disciplina> disciplinas = new HashMap<Integer, Disciplina>();

    public Collection getDisciplinas() {

        return this.disciplinas.values();
    }    

    public Disciplina getDisciplinaById(int id) {

        return this.disciplinas.get(id);
    }

}