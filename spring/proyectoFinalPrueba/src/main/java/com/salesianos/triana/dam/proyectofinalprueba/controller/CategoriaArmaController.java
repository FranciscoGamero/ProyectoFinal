package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;

@Controller
public class CategoriaArmaController {

	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	
	@GetMapping("/nuevo/tipoArma")
	public String nuevoTipoArma(Model model) {
		
		model.addAttribute("nuevoTipo", new CategoriaArma());
		return "menuProductos";
	}
	@PostMapping("/nuevo/tipoArma")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaArma categoria) {
		
		servicioCategoriaArma.save(categoria);
		return "redirect:/productos";
	}
}
