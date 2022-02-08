package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	@Autowired //Para inyectar un objeto que está registrado en el contenedor de Spring. Como hay dos clases concretas que implmentan la interfaz, inyectará el que tenga la anotación @Primary
	//@Qualifier("miServicioComplejo")//Para inyectar una clase concreta que tenga como nombre de componente "miServicioComplejo (independientemente si tiene la anotación @Primary)"
	private IServicio servicio;
	
	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", this.servicio.operacion());
		return "index";
	}

}
