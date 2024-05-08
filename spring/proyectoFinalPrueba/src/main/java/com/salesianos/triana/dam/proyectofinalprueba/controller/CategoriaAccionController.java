package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaAccion;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;

@Controller
public class CategoriaAccionController {

	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	
	@GetMapping("/nuevo/tipoAccion")
	public String nuevoTipoArma(Model model) {
		
		model.addAttribute("nuevoTipo", new CategoriaAccion());
		return "menuProductos";
	}
	@PostMapping("/nuevo/tipoAccion")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaAccion categoria) {
		
		servicioCategoriaAccion.save(categoria);
		return "redirect:/productos";
	}
}
