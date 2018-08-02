package com.example.preMatricula.services;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.preMatricula.entities.Student;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@Service
public class UserService {

	@Autowired
	private StudentService studentService;

	private String[] coordinatorsEmails = {"projsw@ccc.ufcg.edu.br", "javan.lacerda@ccc.ufcg.edu.br"};

	public FirebaseToken getFirebaseTokenFromIdToken(String idToken) throws Exception {
		idToken = idToken.split(" ")[1];
		
		try {
			return FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new Exception("User Not Authenticated");
		}
	}

	public String getUserIdFromIdToken(String idToken) throws Exception {
		return getFirebaseTokenFromIdToken(idToken).getUid();
	}

	public boolean isAuthenticated(String token) {
		try {
			this.getUserIdFromIdToken(token);

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isCoordinator(String token) throws Exception {
		FirebaseToken firebaseToken = this.getFirebaseTokenFromIdToken(token);
		Map<String, Object> claims = firebaseToken.getClaims();
		
		System.out.println(claims.toString());

		for (String coordinatorEmail : this.coordinatorsEmails) {

			if (coordinatorEmail.equals(claims.get("email"))) return true;
		}
		
		return false;
	}

	public ResponseEntity<String> getUser(String token) {
		try {
			FirebaseToken firebaseToken = this.getFirebaseTokenFromIdToken(token);

			if (this.isCoordinator(token)) {
				return new ResponseEntity<>((new JSONObject()).put("role", "Coordinator")
						.put("name", firebaseToken.getName()).put("email", firebaseToken.getEmail()).toString(),
						HttpStatus.OK);
			}

			String uid = this.getUserIdFromIdToken(token);

			if (this.studentService.containsStudent(uid)) {
				Student student = this.studentService.getStudent(uid);
				JSONObject json = new JSONObject();
				json.put("name", student.getName()).put("email", student.getEmail())
						.put("coursePlan", student.getCoursePlan()).put("registration", student.getRegistration())
						.put("semester", student.getSemester()).put("role", "Student");
				return new ResponseEntity<>(json.toString(), HttpStatus.OK);
			} else {
				System.out.println("Chega aqui.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
