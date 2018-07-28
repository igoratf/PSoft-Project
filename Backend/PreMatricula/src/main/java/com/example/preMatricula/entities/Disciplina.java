package com.example.preMatricula.entities;

import org.springframework.data.annotation.Id;
 
public class Disciplina {

   
    @Id
    private String codigo;

    private String nome;

    private int periodo;

    private int creditos;

    private int cargaHoraria;

    private boolean gradeNova = false;

    private boolean gradeAntiga = false;

    public Disciplina() {}

    public Disciplina(String codigo, String nome, int periodo, int creditos, int cargaHoraria, boolean gradeNova, boolean gradeAntiga) {

        this.codigo = codigo;
        this.nome = nome;
        this.periodo = periodo;
        this.creditos = creditos;
        this.cargaHoraria = cargaHoraria;

    }

    public String getNome() {

        return this.nome;
    }

    public int getPeriodo() {

        return this.periodo;
    }

    public String getCodigo() {

        return this.codigo;
    }

    public int getCreditos() {

        return this.creditos;
    }
    
    public int getCargaHoraria() {

        return this.cargaHoraria;
    } 
    
    public String toString() {
    	
    	return this.codigo + " - " + this.nome + " - " + this.periodo;
    	
    }

    public boolean isGradeNova() {

        return this.gradeNova;
    }
    
    public boolean isGradeAntiga() {
        return this.gradeAntiga;
    }

}