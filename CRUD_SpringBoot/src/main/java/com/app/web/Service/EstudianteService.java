package com.app.web.Service;

import java.util.List;

import com.app.web.Entity.Estudiante;

public interface EstudianteService {
	/* Listar Estudiantes */
	public List<Estudiante> listarEstudiantes();
	public Estudiante registrarEstudiante(Estudiante estudiante);
}
