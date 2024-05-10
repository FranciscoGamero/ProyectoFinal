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
import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.service.EquipamientoService;

@Controller
@RequestMapping("/admin")
public class EquipamientoController {

	@Autowired
	private EquipamientoService servicioEquipamiento;

	
	@PostMapping("/nuevoEquipamiento/submit")
	public String procesarFormulario(@ModelAttribute("equipamiento") Equipamiento e) {
		servicioEquipamiento.save(e);
		return "redirect:/admin/productos?mostrarTabla=equip";
	}

	@GetMapping("/editarEquipamiento/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		// Buscamos al alumno por id y recordemos que el método findById del servicio,
		// devuelve el objeto buscado o null si no se encuentra.

		Optional<Equipamiento> eEditar = servicioEquipamiento.findById(id);

		if (eEditar.isPresent()) {
			model.addAttribute("equipamiento", eEditar.get());
			return "admin/editarEquipamiento";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/productos?mostrarTabla=equip";
		}

	}

	@PostMapping("/editarEquipamiento/submit")
	public String procesarFormularioEdicion(@ModelAttribute("equipamiento") Equipamiento e) {
		servicioEquipamiento.edit(e);
	    return "redirect:/admin/productos?mostrarTabla=equip"; // Redireccionar y activar mostrarTablaArmas()
	}
	
	@GetMapping("/eliminarEquipamiento/{id}")
	public String eliminarArma(@PathVariable("id") long id, Model model) {
		Optional<Equipamiento> eBorrar = servicioEquipamiento.findById(id);
		if (eBorrar.isPresent()) {
			servicioEquipamiento.delete(eBorrar.get());
			return "redirect:/admin/productos?mostrarTabla=equip";
		} else {
			return "redirect:/admin/productos?mostrarTabla=equip";
		}
	}
}
