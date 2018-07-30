package com.example.preMatricula.services;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.User;
import com.example.preMatricula.interfaces.UserRepository;
import com.google.firebase.auth.FirebaseAuth;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String getUserIdFromIdToken(String idToken) throws Exception {
		String uid = null;
		try {
			uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
		} catch (InterruptedException | ExecutionException e) {
			throw new Exception("User Not Authenticated");
		}
		return uid;
	}

	public ResponseEntity<String> getUser(String token) {
		try {
			String uid = this.getUserIdFromIdToken(token);
			
			if (this.userRepository.existsById(uid)) {
				return new ResponseEntity<>(this.userRepository.findById(uid).get().toString(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Usuário não encontrado.", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}