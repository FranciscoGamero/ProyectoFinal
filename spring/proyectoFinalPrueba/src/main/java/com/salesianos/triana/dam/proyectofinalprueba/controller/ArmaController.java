package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaPropulsionService;


@Controller
public class ArmaController {

	@Autowired
	private ArmaService service;
	/*
	@Autowired
	private CategoriaArmaService categoria;
	
	@Autowired
	private CategoriaPropulsionService propulsion;
	*/
	@GetMapping("/")
	public String principalAdmin(Model model) {
		model.addAttribute("listaArma", service.findAll());
		return "PrincipalAdmin";
	}
	@GetMapping("/2")
	public String principalSinRegistrar(Model model) {
		model.addAttribute("listaArma", service.findAll());
		return "PrincipalSinRegistrar";
	}
	@GetMapping("/3")
	public String principalUsuario(Model model) {
		model.addAttribute("listaArma", service.findAll());
		return "PrincipalUsuario";
	}
	@GetMapping("/arma")
	public String mostrarArma(@RequestParam Long id, Model model) {
		Arma arma = service.findById(id).get();
		model.addAttribute("arma", arma);
		return "Producto";
	}
	
}
