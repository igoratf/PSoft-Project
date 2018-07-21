package com.example.preMatricula.entities;

import javax.persistence.Entity;

// Futuramente essa classe vai precisar ter a anotação de Entity pra ser 
// interpretada como um modelo do banco de dados, o jpa trabalha assim..

// @Entity
public class Disciplina {

    private int codigo;

    private String nome;

    private int periodo;

    public void Disciplina(int codigo, String nome, int periodo) {

        this.codigo = codigo;
        this.nome = nome;
        this.periodo = periodo;

    }

    public int getCodigo() {

        return this.codigo;
    }

    public String getNome() {

        return this.nome;
    }

    public int getPerido() {

        return this.periodo;
    }

}