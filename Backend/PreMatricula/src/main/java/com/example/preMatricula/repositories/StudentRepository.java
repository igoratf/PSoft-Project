package com.example.preMatricula.repositories;

import com.example.preMatricula.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface StudentRepository extends MongoRepository<User, String> {

}