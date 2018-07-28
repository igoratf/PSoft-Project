package com.example.preMatricula.interfaces;

import com.example.preMatricula.entities.Discipline;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DisciplinaRepository extends MongoRepository<Discipline, Long> {

}