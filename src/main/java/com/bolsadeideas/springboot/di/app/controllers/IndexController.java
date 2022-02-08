package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	@Autowired //Para inyectar un objeto que está registrado en el contenedor de Spring
	private IServicio servicio;
	
	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", this.servicio.operacion());
		return "index";
	}

}
