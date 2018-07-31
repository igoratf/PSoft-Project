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
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String getUserIdFromIdToken(String idToken) throws Exception {
		idToken = idToken.split(" ")[1];
		
		String uid = null;
		try {
			uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Teve erro!");
			System.out.println(e.getMessage());
			throw new Exception("User Not Authenticated");
		}
		return uid;
	}
	
	public boolean isCoordinator(String token) throws Exception {
			String uid = this.getUserIdFromIdToken(token);
			return this.userRepository.findById(uid).get().getRole().equals("Coordinator");
	}

	public ResponseEntity<User> getUser(String token) {
		try {
			String uid = this.getUserIdFromIdToken(token);
			
			if (this.userRepository.existsById(uid)) {
				return new ResponseEntity<>(this.userRepository.findById(uid).get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}