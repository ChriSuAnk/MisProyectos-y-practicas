package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.Repository.EstudianteRepository;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Autowired
	private EstudianteRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Estudiante estudiante1= new
		 * Estudiante("Christian","Mendoza","xkikin@gmail.com"); repo.save(estudiante1);
		 * Estudiante estudiante2= new
		 * Estudiante("Henry","Mendoza","xkikin4741733@gmail.com");
		 * repo.save(estudiante2);
		 */
	}

}
