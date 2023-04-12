package com.app.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@PostMapping("/estudiantes")
	public String RegistrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		service.registrarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	
	
	
	
}
