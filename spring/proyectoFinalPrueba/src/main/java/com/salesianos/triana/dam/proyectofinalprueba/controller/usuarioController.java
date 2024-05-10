package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.service.UsuarioService;

@Controller
public class usuarioController {
	
	@Autowired
	private UsuarioService servicioUsuario;	

	@GetMapping("/admin/usuarios")
	public String listaUsuarios(Model model) {
		model.addAttribute("listaUsuario", servicioUsuario.findAll());
		return "menuUsuarios";
	}
	
	@GetMapping("/formularioRegistro")
	public String mostrarFormulario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm",usuario);
		return "formularioRegistro";
	}
	@PostMapping("/formularioRegistro")
	public String enviarFormulario(@ModelAttribute("usuarioForm") Usuario usuario) {
		servicioUsuario.save(usuario);
		return "redirect:/mostrar/principal";
	}
	
}
