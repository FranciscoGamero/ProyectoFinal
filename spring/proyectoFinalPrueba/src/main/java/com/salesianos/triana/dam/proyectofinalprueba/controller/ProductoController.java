package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.AuxiliarFormulario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.service.ArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.EquipamientoService;
import com.salesianos.triana.dam.proyectofinalprueba.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService servicioProducto;
	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	@Autowired
	private ArmaService servicioArma;
	@Autowired
	private EquipamientoService servicioEquipamiento;

	@GetMapping("/")
	public String principalUsuario(Model model) {
		model.addAttribute("listaProducto", servicioProducto.findAll());
		return "PrincipalUsuario";
	}

	@GetMapping("/mostrar/producto")
	public String mostrarProducto(@RequestParam Long id, Model model) {
		Producto producto = servicioProducto.findById(id).get();
		model.addAttribute("producto", producto);
		model.addAttribute("tipoProducto", producto.getClass().getSimpleName());
		return "DetalleProducto";
	}

	@GetMapping("/admin/productos")
	public String mostrarProductos(Model model) {
		model.addAttribute("listaProductos", servicioProducto.findAll());
		model.addAttribute("listaArmas", servicioProducto.getListaArmas());
		model.addAttribute("listaEquipamiento", servicioProducto.getListaEquipamiento());
		return "admin/menuProductos";
	}

	@GetMapping("/admin/agregarProductos")
	public String agregarProducto(Model model) {
		model.addAttribute("formProducto", new AuxiliarFormulario());
		model.addAttribute("tiposAccion", servicioCategoriaAccion.findAll());
		model.addAttribute("tiposArma", servicioCategoriaArma.findAll());
		return "admin/agregarProducto";
	}

	@PostMapping("/admin/agregarProductos/submit")
	public String enviarProducto(@ModelAttribute("formProducto") AuxiliarFormulario producto) {
		if (producto.getA().getFormaDisparo() !=null) {
			servicioArma.save(servicioArma.montarArma(producto.getP(), producto.getA()));
		} else if (producto.getE() != null) {
			servicioEquipamiento.save(servicioEquipamiento.montarEquipamiento(producto.getP(), producto.getE()));
		}
		return "redirect:/admin/productos";
	}
}
