package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ArmaController {

	@Autowired
	private ArmaService service;
	
	@GetMapping("/")
	public String getMethodName(Model model) {
		model.addAttribute("listaArma", service.getLista());
		return "PrincipalAdmin";
	}
	
	
}
