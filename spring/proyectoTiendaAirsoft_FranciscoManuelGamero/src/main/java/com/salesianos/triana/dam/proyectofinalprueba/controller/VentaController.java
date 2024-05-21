package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;
import com.salesianos.triana.dam.proyectofinalprueba.service.VentaService;



@Controller
public class VentaController {

	@Autowired
	VentaService servicioVentas;
	
	
	@GetMapping("/verPerfil/listaPedidos")
	public String verListaPedidos(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("listaPedidos", usuario.getListaVentas());
		return "menuPedidos";
	}
	@GetMapping("/verPerfil/listaPedidos/verPedido/{id}")
	public String verPedido(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("pedido", servicioVentas.findById(id).get().getListaLineasVentas());
		model.addAttribute("venta",servicioVentas.findById(id).get());
		return "detallePedido";
		
	}
	@GetMapping("/admin/eliminarVenta/{id}")
	public String eliminarVenta(@PathVariable("id") long id, Model model) {
		Venta vBorrar = servicioVentas.buscarPorId(id);
			servicioVentas.delete(vBorrar);
			return "redirect:/admin/verListaVentas";
	}
}
