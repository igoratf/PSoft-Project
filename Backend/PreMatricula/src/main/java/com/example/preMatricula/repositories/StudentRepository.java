package com.example.preMatricula.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.preMatricula.entities.Student;
 
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}