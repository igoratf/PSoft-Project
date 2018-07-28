package com.example.preMatricula.entities;


public class Aluno {

    private String emailCCC;
    private String numMatricula;

    public Aluno(String emailCCC, String numMatricula) {

        this.emailCCC = emailCCC;
        this.numMatricula = numMatricula;
    }

    public String getEmail() {

        return this.emailCCC;
    }

    public String getNumMatricula() {
        return this.numMatricula;
    }

    public void setNumMatricula(String numMatricula) {

        this.numMatricula = numMatricula;

    }
}