package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;

@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	
	@GetMapping("/verTablaTipos")
	public String mostrarTablaTipos(Model model) {
		model.addAttribute("listaTipoArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaTipoAccion", servicioCategoriaAccion.findAll());
		return "menuTipos";
	}
}
