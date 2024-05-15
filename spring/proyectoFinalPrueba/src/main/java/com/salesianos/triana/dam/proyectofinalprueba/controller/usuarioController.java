package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.service.UsuarioService;

@Controller
public class usuarioController {
	
	@Autowired
	private UsuarioService servicioUsuario;	
	
	@GetMapping("/formularioRegistro")
	public String mostrarFormulario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm",usuario);
		return "formularioRegistro";
	}
	@PostMapping("/formularioRegistro/submit")
	public String enviarFormulario(@ModelAttribute("usuarioForm") Usuario usuario) {
		servicioUsuario.save(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/admin/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		// Buscamos al alumno por id y recordemos que el método findById del servicio,
		// devuelve el objeto buscado o null si no se encuentra.

		Optional<Usuario> uEditar = servicioUsuario.findById(id);

		if (uEditar.isPresent()) {
			model.addAttribute("usuario", uEditar.get());
			return "admin/editarUsuario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/admin/usuarios";
		}

	}
	@PostMapping("/admin/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario usuario) {
		servicioUsuario.edit(usuario);
		return "redirect:/admin/usuarios";
	}
	@GetMapping("/admin/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> uBorrar = servicioUsuario.findById(id);
		if (uBorrar.isPresent()) {
			servicioUsuario.delete(uBorrar.get());
			return "redirect:/admin/usuarios";
		} else {
			return "redirect:/admin/usuarios";
		}
	}
	@GetMapping("/verPerfil")
	public String verPerfil(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("usuario",usuario);
		return "verPerfil";
	}
}
