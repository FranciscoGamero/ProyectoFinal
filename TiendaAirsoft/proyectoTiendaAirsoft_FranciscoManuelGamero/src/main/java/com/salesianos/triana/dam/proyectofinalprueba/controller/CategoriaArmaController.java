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
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;

@Controller
@RequestMapping("/admin")
public class CategoriaArmaController {

	@Autowired
	private CategoriaArmaService servicioCategoriaArma;

	@GetMapping("/nuevo/tipoArma")
	public String nuevoTipoArma(Model model) {

		model.addAttribute("nuevoTipo", new CategoriaArma());
		return "admin/agregarCategoriaArma";
	}

	@PostMapping("/nuevo/tipoArma/submit")
	public String enviarNuevoTipoArma(@ModelAttribute("nuevoTipo") CategoriaArma categoria) {

		servicioCategoriaArma.save(categoria);
		return "redirect:/admin/verTablaTipos";
	}

	@GetMapping("/eliminarTipoArma/{id}/")
	public String eliminarTipoArma(@PathVariable("id") long id, Model model) {
		CategoriaArma tABorrar = servicioCategoriaArma.buscarPorId(id);
		if (servicioCategoriaArma.hayUnaVenta(tABorrar)==0) {
			servicioCategoriaArma.delete(tABorrar);
			return "redirect:/admin/verTablaTipos/";
		} else {
			return "redirect:/admin/verTablaTipos/?error=true";
		}
	}
	@GetMapping("editarTipoArma/{id}")
	public String editarTipoArma(@PathVariable("id") long id, Model model) {
		
		CategoriaArma cAEditar = servicioCategoriaArma.buscarPorId(id);
			model.addAttribute("tipoArma", cAEditar);
			return "admin/editarCategoriaArma";
		

	}
	@PostMapping("/editarTipoArma/submit")
	public String enviarEdicionTipoArma(@ModelAttribute("tipoArma") CategoriaArma cA) {
		servicioCategoriaArma.edit(cA);
	    return "redirect:/admin/verTablaTipos"; // Redireccionar y activar mostrarTablaArmas()
	}
}
