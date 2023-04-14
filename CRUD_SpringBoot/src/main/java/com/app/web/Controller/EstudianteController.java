package com.app.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.Entity.Estudiante;
import com.app.web.Service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService service;

	@GetMapping({ "/home" })
	public String principal() {
		return "index";
	}
	
	/*Controlador para Listar a los Estudiantes de la BD*/
	@GetMapping({ "/estudiantes" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", service.listarEstudiantes());
		return "/html/estudiantes";
	}
	
	/*Controlador para mostrar formulario para registrar al estudiante*/
	@GetMapping("/estudiantes/registro")
	public String MostrarFormulario_RegistrarEstudiante(Model model) {
		
		Estudiante estudiante=new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "/html/registrar_estudiante";
	}
	
	/*Controlador para poder registrar a un Estudiante*/
	@PostMapping("/estudiantes")
	public String RegistrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		service.registrarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	
	/*Controlador para poder mostrar el formulario para editar Estudiante*/
	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormulario_EditarEstudiante(@PathVariable Long id,Model model) {
		model.addAttribute("estudiante",service.obtenerEstudianteId(id));
		return "/html/editar_estudiante";
	}
	
	@PostMapping("/estudiantes/{id}")
	public String ediarEstudiante(@PathVariable Long id,@ModelAttribute("estudiante") Estudiante estudiante,Model model) {
		Estudiante estudianteExistente = service.obtenerEstudianteId(id);
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		
		service.ActualizarEstudiante(estudianteExistente);
		
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		service.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
}
