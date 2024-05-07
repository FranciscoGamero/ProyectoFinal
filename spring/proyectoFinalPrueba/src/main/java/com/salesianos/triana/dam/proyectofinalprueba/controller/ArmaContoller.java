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
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;

@Controller
public class ArmaContoller {

	@Autowired
	private ArmaService servicioArma;
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("arma") Arma a) {
		servicioArma.save(a);
		return "redirect:/productos";
	}
	
	@GetMapping("/editarArma/{id}")
	public String editarArma(@PathVariable Long id, Model model) {
	    // Lógica para cargar los datos del arma desde la base de datos u otro origen de datos
	    Arma arma = servicioArma.findById(id).get();
	    model.addAttribute("arma", arma);
	    return "menuProductos"; // Devuelve el nombre de la plantilla Thymeleaf del modal
	}
	
	/**
	 * Método que procesa la petición post del formulario al editar
	 * agregar el alumno de nuevo
	 */
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("arma") Arma a) {
		servicioArma.edit(a);
		return "redirect:/productos";//Volvemos a redirigir la listado a través del controller 
		//para pintar la lista actualizada con la modificación hecha
	}
}
