package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;

@Controller
@RequestMapping("/admin")
public class ArmaContoller {

	@Autowired
	private ArmaService servicioArma;

	@Autowired
	private CategoriaArmaService servicioCatArma;

	@Autowired
	private CategoriaAccionService servicioCatAccion;

	@PostMapping("/nuevoArma/submit")
	public String procesarFormulario(@ModelAttribute("arma") Arma a) {
		servicioArma.save(a);
		return "redirect:/productos";
	}
	
	@GetMapping("/editarArma/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		// Buscamos al alumno por id y recordemos que el método findById del servicio,
		// devuelve el objeto buscado o null si no se encuentra.

		Optional<Arma> aEditar = servicioArma.findById(id);

		if (aEditar.isPresent()) {
			model.addAttribute("arma", aEditar.get());
			model.addAttribute("tiposArma", servicioCatArma.findAll());
			model.addAttribute("tiposAccion", servicioCatAccion.findAll());
			return "admin/editarArma";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/productos?mostrarTabla=arma";
		}

	}

	@PostMapping("/editarArma/submit")
	public String procesarFormularioEdicion(@ModelAttribute("arma") Arma a) {
		servicioArma.edit(a);
		return "redirect:/admin/productos?mostrarTabla=arma"; // Redireccionar y activar mostrarTablaArmas()
	}
	@GetMapping("/eliminarArma/{id}")
	public String eliminarArma(@PathVariable("id") long id) {
		Optional<Arma> aBorrar = servicioArma.findById(id);
		if (aBorrar.isPresent()) {
			servicioArma.delete(aBorrar.get());
			return "redirect:/admin/productos?mostrarTabla=arma";
		} else {
			return "redirect:/admin/productos?mostrarTabla=arma";
		}
	}
	
}
