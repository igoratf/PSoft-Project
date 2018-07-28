package com.example.preMatricula.interfaces;

import com.example.preMatricula.entities.Matricula;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface MatriculaRepository extends MongoRepository<Matricula, String> {

}