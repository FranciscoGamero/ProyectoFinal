package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
