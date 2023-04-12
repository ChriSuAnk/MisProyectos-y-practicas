package com.app.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.Entity.Estudiante;
import com.app.web.Repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository repositorio;

	@Override
	public List<Estudiante> listarEstudiantes() {
		return repositorio.findAll();
	}

	@Override
	public Estudiante registrarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

}
