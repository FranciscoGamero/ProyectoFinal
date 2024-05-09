package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;

@Controller
public class CategoriaArmaController {

	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	
	@GetMapping("/nuevo/tipoArma")
	public String nuevoTipoArma(Model model) {
		
		model.addAttribute("nuevoTipo", new CategoriaArma());
		return "agregarCategoriaArma";
	}
	@PostMapping("/nuevo/tipoArma/submit")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaArma categoria) {
		
		servicioCategoriaArma.save(categoria);
		return "redirect:/productos";
	}
	@GetMapping("/eliminarTipoArma/{id}")
	public String eliminarArma(@PathVariable("id") long id, Model model) {
		Optional<CategoriaArma> tABorrar = servicioCategoriaArma.findById(id);
		if (tABorrar.isPresent()) {
			servicioCategoriaArma.delete(tABorrar.get());
			return "redirect:/productos?mostrarTabla=arma";
		} else {
			return "redirect:/productos?mostrarTabla=arma";
		}
	}
}
