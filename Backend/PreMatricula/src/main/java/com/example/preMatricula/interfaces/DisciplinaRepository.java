package com.example.preMatricula.interfaces;

import com.example.preMatricula.entities.Disciplina;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {

}