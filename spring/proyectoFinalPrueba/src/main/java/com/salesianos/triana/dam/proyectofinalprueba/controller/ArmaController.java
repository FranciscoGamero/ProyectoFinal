package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;



@Controller
public class ArmaController {

	@Autowired
	private ArmaService servicioArma;
	@Autowired 
	private CategoriaAccionService servicioCategoriaAccion;
	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	
	@GetMapping("/h")
	public String principalAdmin(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalAdmin";
	}
	@GetMapping("/")
	public String principalSinRegistrar(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalSinRegistrar";
	}
	@GetMapping("/3")
	public String principalUsuario(Model model) {
		model.addAttribute("listaArma", servicioArma.findAll());
		return "PrincipalUsuario";
	}
	@GetMapping("/arma")
	public String mostrarArma(@RequestParam Long id, Model model) {
		Arma arma = servicioArma.findById(id).get();

		
		model.addAttribute("arma", arma);

		return "Producto";
	}
	@GetMapping("/productos")
	public String mostrarProductos(Model model){
		model.addAttribute("listaProductos", servicioArma.findAll()); //Esto debería ser en ProductoController
		return "menuProductos";
	}
	@GetMapping("/agregarp")
	public String agregarProducto(Model model) {
		Producto p = new Producto();
		model.addAttribute("formProducto", p);
		model.addAttribute("tiposAccion", servicioCategoriaAccion.findAll());
		model.addAttribute("tiposArma", servicioCategoriaArma.findAll());
		return "agregarProducto";
	}
	@PostMapping("/agregarp")
	public String enviarProducto(@ModelAttribute("productoForm") Producto producto, Model model) {
		
			model.addAttribute("producto", producto);
			return "redirect:/productos";			
	}
}
