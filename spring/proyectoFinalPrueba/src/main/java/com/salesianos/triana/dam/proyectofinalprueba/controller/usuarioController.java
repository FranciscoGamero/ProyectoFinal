package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;

import jakarta.annotation.PostConstruct;

@Controller
public class usuarioController {
	
	@GetMapping("/4")
	public String mostrarFormulario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm",usuario);
		return "formularioRegistro";
	}
	@PostMapping("/addUsuario")
	public String enviarFormulario(@ModelAttribute("usuarioForm") Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "mostrarFormulario";
	}
}
