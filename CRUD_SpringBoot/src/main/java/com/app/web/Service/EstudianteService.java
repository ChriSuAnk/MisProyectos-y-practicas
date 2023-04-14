package com.app.web.Service;

import java.util.List;

import com.app.web.Entity.Estudiante;

public interface EstudianteService {
	/* Listar Estudiantes */
	public List<Estudiante> listarEstudiantes();
	public Estudiante registrarEstudiante(Estudiante estudiante);
	public Estudiante obtenerEstudianteId(Long id);
	public Estudiante ActualizarEstudiante(Estudiante estudiante);
	public void eliminarEstudiante(Long id);
}
