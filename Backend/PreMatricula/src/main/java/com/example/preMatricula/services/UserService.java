package com.example.preMatricula.services;

public interface UserService {

	public void saveUser(String idToken) throws Exception;

	public String getUserIdFromIdToken(String idToken) throws Exception;
}