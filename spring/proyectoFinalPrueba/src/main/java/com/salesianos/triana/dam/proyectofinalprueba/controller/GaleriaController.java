package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Galeria;
import com.salesianos.triana.dam.proyectofinalprueba.service.GaleriaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.TipoGaleriaService;

@Controller
public class GaleriaController {
	
	@Autowired
	GaleriaService servicioGaleria;
	@Autowired
	TipoGaleriaService servicioTipoGaleria;

	/*
	@GetMapping("/galerias")
	public String principalUsuarioGaleria(Model model) {
		model.addAttribute("listaGalerias", servicioGaleria.findAll());
		return "PrincipalUsuario";
	}
	
	@GetMapping("/mostrar/galeria")
	public String mostrarGaleria(@RequestParam Long id, Model model) {
		Galeria galeria = servicioGaleria.findById(id).get();
		model.addAttribute("galeria", galeria);
		return "DetalleProducto";
	}
	*/

	@GetMapping("/admin/galerias")
	public String mostrarGalerias(Model model) {
		model.addAttribute("listaGaleria", servicioGaleria.findAll());
		return "admin/menuGalerias";
	}

	@GetMapping("/admin/agregarGalerias")
	public String agregarGaleria(Model model) {
		model.addAttribute("galeria", new Galeria());
		model.addAttribute("tiposGaleria", servicioTipoGaleria.findAll());
		return "admin/agregarGaleria";
	}

	@PostMapping({"/admin/agregarGalerias/submit","/admin/nuevaGaleria/submit"})
	public String enviarGaleria(@ModelAttribute("galeria") Galeria galeria) {
		servicioGaleria.save(galeria);
		return "redirect:/admin/galerias";
	}
	@GetMapping("/admin/editarGaleria/{id}")
	public String mostrarEditarGaleria(@PathVariable("id") long id, Model model) {

		Optional<Galeria> gEditar = servicioGaleria.findById(id);

		if (gEditar.isPresent()) {
			model.addAttribute("galeria", gEditar.get());
			model.addAttribute("tiposGaleria", servicioTipoGaleria.findAll());
			return "admin/editarGaleria";
		} else {
			
			return "redirect:/admin/galerias";
		}

	}

	@PostMapping("/admin/editarGaleria/submit")
	public String procesarEditarGaleria(@ModelAttribute("galeria") Galeria galeria) {
		servicioGaleria.edit(galeria);
		return "redirect:/admin/galeria";
	}
	@GetMapping("/admin/eliminarGaleria/{id}")
	public String eliminarGaleria(@PathVariable("id") long id, Model model) {
		Optional<Galeria> gBorrar = servicioGaleria.findById(id);
		if (gBorrar.isPresent()) {
			servicioGaleria.delete(gBorrar.get());
			return "redirect:/admin/galerias";
		} else {
			return "redirect:/admin/galerias";
		}
	}
}
