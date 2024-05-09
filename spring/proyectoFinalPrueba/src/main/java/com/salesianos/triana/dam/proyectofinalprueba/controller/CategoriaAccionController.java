package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaAccion;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;

@Controller
public class CategoriaAccionController {

	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	
	@GetMapping("/nuevo/tipoAccion")
	public String nuevoTipoArma(Model model) {
		
		model.addAttribute("nuevoTipo", new CategoriaAccion());
		return "agregarCategoriaAccion";
	}
	@PostMapping("/nuevo/tipoAccion/submit")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaAccion categoria) {
		
		servicioCategoriaAccion.save(categoria);
		return "redirect:/productos";
	}
	@GetMapping("/eliminarTipoAccion/{id}")
	public String eliminarArma(@PathVariable("id") long id, Model model) {
		Optional<CategoriaAccion> tABorrar = servicioCategoriaAccion.findById(id);
		if (tABorrar.isPresent()) {
			servicioCategoriaAccion.delete(tABorrar.get());
			return "redirect:/verTablaTipos";
		} else {
			return "redirect:/verTablaTipos";
		}
	}
}
