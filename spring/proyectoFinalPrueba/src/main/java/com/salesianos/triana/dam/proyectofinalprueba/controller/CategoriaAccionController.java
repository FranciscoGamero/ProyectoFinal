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
	@GetMapping("/eliminarTipoAccion/{id}")
	public String eliminarTipoAccion(@PathVariable("id") long id, Model model) {
		CategoriaAccion tABorrar = servicioCategoriaAccion.buscarPorId(id);
		if (servicioCategoriaAccion.hayUnaVenta(tABorrar)==0) {
			servicioCategoriaAccion.delete(tABorrar);
			return "redirect:/admin/verTablaTipos";
		} else {
			return "redirect:/admin/verTablaTipos?error=true";
		}
	}
	@GetMapping("/editarTipoAccion/{id}")
	public String editarTipoAccion(@PathVariable("id") long id, Model model) {
		
		CategoriaAccion cAEditar = servicioCategoriaAccion.buscarPorId(id);
			model.addAttribute("tipoAccion", cAEditar);
			return "admin/editarCategoriaAccion";

	}
	@PostMapping("/editarTipoAccion/submit")
	public String enviarEdicionTipoAccion(@ModelAttribute("tipoAccion") CategoriaAccion cA) {
		servicioCategoriaAccion.edit(cA);
	    return "redirect:/admin/verTablaTipos";
	}
}
