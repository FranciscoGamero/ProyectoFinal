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

	@GetMapping("/info/QuienesSomos")
	public String mostrarQuienesSomos() {
		return "quienesSomos";
	}

	@GetMapping("/info/AvisoLegal")
	public String mostrarAvisoLegal() {
		return "avisoLegal";
	}

	@GetMapping("/formularioRegistro")
	public String mostrarFormulario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm", usuario);
		return "formularioRegistro";
	}

	@PostMapping("/formularioRegistro/submit")
	public String enviarFormulario(@ModelAttribute("usuarioForm") Usuario usuario) {
		servicioUsuario.save(usuario);
		return "redirect:/";
	}

	@GetMapping("/admin/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Usuario uEditar = servicioUsuario.buscarPorId(id);

		model.addAttribute("usuario", uEditar);
		return "admin/editarUsuario";
	}

	@PostMapping("/admin/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario usuario) {
		servicioUsuario.edit(usuario);
		return "redirect:/admin/usuarios";
	}

	@GetMapping("/admin/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable("id") long id, Model model) {
		Usuario uBorrar = servicioUsuario.buscarPorId(id);
		if (servicioUsuario.hayUnaVenta(uBorrar) == 0) {
			servicioUsuario.delete(uBorrar);
			return "redirect:/admin/usuarios";
		} else {
			return "redirect:/admin/usuarios?error=true";
		}
	}

	@GetMapping("/verPerfil")
	public String verPerfil(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "verPerfil";
	}
}
