package com.example.preMatricula.repositories;

import com.example.preMatricula.entities.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserRepository extends MongoRepository<Student, String> {

}