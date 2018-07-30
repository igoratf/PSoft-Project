package com.example.preMatricula.interfaces;

import com.example.preMatricula.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}