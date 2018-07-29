package com.example.preMatricula.interfaces;

import com.example.preMatricula.entities.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}