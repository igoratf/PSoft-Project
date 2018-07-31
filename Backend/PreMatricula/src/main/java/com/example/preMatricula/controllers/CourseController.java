package com.example.preMatricula.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.preMatricula.services.CourseService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PutMapping(path = "/enroll")
	public ResponseEntity<String> enroll(@RequestBody List<Integer> disciplineCodes,
			@RequestHeader(name = "Authorization") String token) throws Exception {

		return this.courseService.enroll(disciplineCodes, token);
	}

}
