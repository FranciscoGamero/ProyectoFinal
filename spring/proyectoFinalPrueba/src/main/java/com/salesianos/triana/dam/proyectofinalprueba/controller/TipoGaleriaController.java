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

import com.salesianos.triana.dam.proyectofinalprueba.model.Galeria;
import com.salesianos.triana.dam.proyectofinalprueba.model.TipoGaleria;
import com.salesianos.triana.dam.proyectofinalprueba.service.TipoGaleriaService;

@Controller
@RequestMapping("/admin")
public class TipoGaleriaController {

	@Autowired
	private TipoGaleriaService servicioTipoGaleria;

	@GetMapping("/nuevo/tipoGaleria")
	public String nuevoTipoGaleria(Model model) {

		model.addAttribute("nuevoTipo", new TipoGaleria());
		return "admin/agregarTipoGaleria";
	}

	@PostMapping("/nuevo/tipoGaleria/submit")
	public String enviarNuevoTipoGaleria(@ModelAttribute("nuevoTipo") TipoGaleria nuevoTipo) {

		servicioTipoGaleria.save(nuevoTipo);
		return "redirect:/admin/tiposGaleria";
	}

	@GetMapping("/editarTipoGaleria/{id}")
	public String mostrarEditarGaleria(@PathVariable("id") long id, Model model) {

		Optional<TipoGaleria> tGEditar = servicioTipoGaleria.findById(id);
		if (tGEditar.isPresent()) {
			model.addAttribute("tipoGaleria", tGEditar.get());
			return "admin/editarTipoGaleria";
		} else {
			return "redirect:/admin/tiposGaleria";
		}
	}

	@PostMapping("/editarTipoGaleria/submit")
	public String procesarEditarTipoGaleria(@ModelAttribute("tipoGaleria") TipoGaleria tipo) {
		servicioTipoGaleria.edit(tipo);
		return "redirect:/admin/tiposGaleria";
	}
	@GetMapping("/eliminarTipoGaleria/{id}/")
	public String eliminarGaleria(@PathVariable("id") long id, Model model) {
		Optional<TipoGaleria> tGBorrar = servicioTipoGaleria.findById(id);
		if (tGBorrar.isPresent()) {
			servicioTipoGaleria.delete(tGBorrar.get());
			return "redirect:/admin/tiposGaleria";
		} else {
			return "redirect:/admin/tiposGaleria";
		}
	}
}