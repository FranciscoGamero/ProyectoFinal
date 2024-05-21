package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.Galeria;
import com.salesianos.triana.dam.proyectofinalprueba.model.Reserva;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.service.GaleriaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.ReservaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.TipoGaleriaService;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService servicioReserva;
	
	@Autowired
	GaleriaService servicioGaleria;
	@Autowired
	TipoGaleriaService servicioTipoGaleria;

	@GetMapping("/realizarReserva/{id}")
	public String enviarReserva(Model model, @PathVariable("id") long id) {
		Galeria galeria = servicioGaleria.findById(id).get();
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("galeria", galeria);
		return "formularioReserva";
	}
	@PostMapping("/realizarReserva/submit")
	public String procesarReserva(@AuthenticationPrincipal Usuario usuario, @ModelAttribute("reserva") Reserva reserva,
			@RequestParam("galeriaId") long galeriaId) {
		if(reserva.getFechaInicioReserva().isAfter(LocalDateTime.now()) 
				&& reserva.getFechaFinReserva().isAfter(reserva.getFechaInicioReserva())) {
        reserva.setGaleria(servicioGaleria.findById(galeriaId).get());
        reserva.establecerImporteTotal();
        reserva.setComprador(usuario);
        servicioReserva.save(reserva);
		return "redirect:/galerias";
		} else {
			return "redirect:/galerias?error=true";
		}
	}
	@GetMapping("/verPerfil/listaReservas")
	public String verListaReservas(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("listaReservas", usuario.getListaReservas());
		return "menuReservas";
	}
}
