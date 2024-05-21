package com.salesianos.triana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.service.CarritoService;
import com.salesianos.triana.dam.proyectofinalprueba.service.ProductoService;
import com.salesianos.triana.dam.proyectofinalprueba.service.VentaService;

@Controller
public class CarritoController {
	@Autowired
	private CarritoService servicioCarrito;
	
	@Autowired
	private ProductoService servicioProducto;
	@Autowired
	private VentaService servicioVenta;
	
	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Usuario usuario, Model model) {
		if(servicioCarrito.hayCarritoCreado(usuario)) {
			model.addAttribute("lineasDelCarrito",servicioCarrito.getProductosEnCarrito(usuario));
			model.addAttribute("carrito", servicioCarrito.getCarrito(usuario));
			model.addAttribute("usuario", usuario);
		} else {
			servicioVenta.save(servicioCarrito.crearCarrito(usuario));
		}
		return "carrito";
	}
	@GetMapping("/productoACarrito/")
	public String productoACarrito(@AuthenticationPrincipal Usuario usuario, @RequestParam Long id,Model model) {
		Optional<Producto> producto = servicioProducto.findById(id);
		if(producto.isPresent()) {
			servicioCarrito.addProducto(usuario, producto.get(), 1);
			return "redirect:/carrito";
		}
		return "redirect:/";
	}
	@GetMapping("/terminarCompra")
	public String finalizarCompra(@AuthenticationPrincipal Usuario usuario) {
		servicioCarrito.finalizarCompra(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/carrito/modificar/{id}/cantidad/{cant}")
	public String modificarCantProducto(@AuthenticationPrincipal Usuario usuario,@PathVariable ("id") Long id,
			@PathVariable ("cant") int cant) {
		Optional<Producto> producto = servicioProducto.findById(id);
		if(producto.isPresent()) {
			servicioCarrito.modificarCantidad(usuario, producto.get(), cant);
		}
		return "redirect:/carrito";
	}
	@GetMapping("/carrito/eliminar/{id}")
	public String eliminarProducto(@AuthenticationPrincipal Usuario usuario, @PathVariable ("id") Long id) {
	        Optional <Producto> producto = servicioProducto.findById(id);
	        if(producto.isPresent()) {
	           servicioCarrito.eliminarProducto(usuario, producto.get());
	           return "redirect:/carrito";
	        }
		return "redirect:/carrito";
	}
}
