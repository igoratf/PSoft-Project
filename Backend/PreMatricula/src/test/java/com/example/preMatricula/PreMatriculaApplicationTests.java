package com.example.preMatricula;

import com.example.preMatricula.entities.Discipline;
import com.example.preMatricula.entities.Grade;
import com.example.preMatricula.interfaces.DisciplinaRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreMatriculaApplicationTests {

	@Autowired
	DisciplinaRepository disciplinas;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testBD() {

		disciplinas.deleteAll();

		disciplinas.save(new Discipline("eda", 123L, 3, 0, Grade.Both));

		System.out.println(disciplinas.findAll());
	}

}
