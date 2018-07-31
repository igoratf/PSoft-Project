package com.example.preMatricula;

import com.example.preMatricula.services.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.preMatricula.repositories.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreMatriculaApplicationTests {

	@Autowired
	UserService user;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStudent() throws Exception {

		

	}

}
