package com.example.preMatricula.services;

public interface UserService {

	public boolean isAuthenticated(String idToken) throws Exception;

	public String getUserIdFromIdToken(String idToken) throws Exception;
}