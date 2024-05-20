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

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaAccion;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;

@Controller
@RequestMapping("/admin")
public class CategoriaAccionController {

	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	
	@GetMapping("/nuevo/tipoAccion")
	public String nuevoTipoArma(Model model) {
		
		model.addAttribute("nuevoTipo", new CategoriaAccion());
		return "admin/agregarCategoriaAccion";
	}
	@PostMapping("/nuevo/tipoAccion/submit")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaAccion categoria) {
		
		servicioCategoriaAccion.save(categoria);
		return "redirect:/admin/verTablaTipos";
	}
	@GetMapping("/eliminarTipoAccion/{id}/")
	public String eliminarTipoAccion(@PathVariable("id") long id, Model model) {
		Optional<CategoriaAccion> tABorrar = servicioCategoriaAccion.findById(id);
		if (tABorrar.isPresent()) {
			servicioCategoriaAccion.delete(tABorrar.get());
			return "redirect:/admin/verTablaTipos";
		} else {
			return "redirect:/admin/verTablaTipos";
		}
	}
	@GetMapping("/editarTipoAccion/{id}")
	public String editarTipoAccion(@PathVariable("id") long id, Model model) {
		
		Optional<CategoriaAccion> cAEditar = servicioCategoriaAccion.findById(id);

		if (cAEditar.isPresent()) {
			model.addAttribute("tipoAccion", cAEditar.get());
			return "admin/editarCategoriaAccion";
		} else {

			return "redirect:/admin/verTablaTipos";
		}

	}
	@PostMapping("/editarTipoAccion/submit")
	public String enviarEdicionTipoAccion(@ModelAttribute("tipoAccion") CategoriaAccion cA) {
		servicioCategoriaAccion.edit(cA);
	    return "redirect:/admin/verTablaTipos"; // Redireccionar y activar mostrarTablaArmas()
	}
}
