package com.app.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.Service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService service;

	@GetMapping({ "/home" })
	public String principal() {
		return "index";
	}

	@GetMapping({ "/estudiantes" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", service.listarEstudiantes());
		return "/html/estudiantes";
	}
}
