package com.example.preMatricula.entities;

import java.util.Collection;

import org.springframework.data.annotation.Id;

public class Matricula {

    @Id
    private String id;

    private Aluno aluno;

    private Collection<String> codDisciplinas;

    public Matricula(Aluno aluno, Collection<String> codDisciplinas)   {

        this.aluno = aluno;
        this.codDisciplinas = codDisciplinas;

    }

    public String getId() {

        return this.id;
    }

    public Aluno getAluno() {

        return this.aluno;
    }

    public Collection<String> getCodigosDisciplinas() {

        return this.codDisciplinas;
    }

}