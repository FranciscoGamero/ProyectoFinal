package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;



@Controller
public class ArmaController {

	@Autowired
	private ArmaService servicioArma;
	
	@GetMapping("/h")
	public String principalAdmin(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalAdmin";
	}
	@GetMapping("/2")
	public String principalSinRegistrar(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalSinRegistrar";
	}
	@GetMapping("/3")
	public String principalUsuario(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalUsuario";
	}
	@GetMapping("/arma")
	public String mostrarArma(@RequestParam Long id, Model model) {
		Arma arma = servicioArma.findById(id).get();

		
		model.addAttribute("arma", arma);

		return "Producto";
	}
	@GetMapping("/productos")
	public String mostrarProductos(Model model){
		model.addAttribute("listaProductos", servicioArma.findAll()); //Esto debería ser en ProductoController
		return "menuProductos";
	}
}
