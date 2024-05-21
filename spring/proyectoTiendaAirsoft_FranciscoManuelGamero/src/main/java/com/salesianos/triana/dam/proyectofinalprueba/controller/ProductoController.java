package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.proyectofinalprueba.model.AuxiliarFormulario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Talla;
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

	@GetMapping({"/principal","/"})
	public String principalUsuario(Model model) {
		model.addAttribute("listaProducto", servicioProducto.findAll());
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
		return "PrincipalUsuario";
	}
	
	@GetMapping("/principal/buscarProductos/masNuevos")
    public String buscarMasNuevos(Model model) {
        model.addAttribute("listaProducto", servicioProducto.buscarMasNuevos());
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
        return "PrincipalUsuario";
    }
	
	@GetMapping("/principal/buscarProductos/masBaratos")
    public String buscarMasBaratos(Model model) {
        model.addAttribute("listaProducto", servicioProducto.buscarMasBaratos());
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
        return "PrincipalUsuario";
    }
	
	@GetMapping("/principal/buscarProducto")
    public String buscarPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
        model.addAttribute("listaProducto", servicioProducto.buscarPorNombre(busqueda));
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
        return "PrincipalUsuario";
    }
	
	@GetMapping("/principal/categoriaArma{id}")
		public String principalFiltradaPorCategoriaArma(Model model, @PathVariable ("id") long id) {
			model.addAttribute("listaProducto", servicioArma.buscarPorCategoriaArma(id));
			model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
			model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
			return "PrincipalUsuario";
		}
	@GetMapping("/principal/categoriaAccion{id}")
	public String principalFiltradaPorCategoriaAccion(Model model, @PathVariable ("id") long id) {
		model.addAttribute("listaProducto", servicioArma.buscarPorCategoriaAccion(id));
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
		return "PrincipalUsuario";
	}
	@GetMapping("/mostrar/producto")
	public String mostrarProducto(@RequestParam Long id, Model model) {
		Producto producto = servicioProducto.findById(id).get();
		model.addAttribute("producto", producto);
		model.addAttribute("tipoProducto", producto.getClass().getSimpleName());
		return "DetalleProducto";
	}
	@GetMapping("/principal/color")
	public String principalFiltradaPorCategoriaArma(Model model, @RequestParam("color") String color) {
		model.addAttribute("listaProducto", servicioEquipamiento.buscarPorColor(color));
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
		return "PrincipalUsuario";
	}
	@GetMapping("/principal/color{talla}")
	public String principalFiltradaPorCategoriaArma(Model model, @PathVariable ("talla") Talla talla) {
		model.addAttribute("listaProducto", servicioEquipamiento.buscarPorTalla(talla));
		model.addAttribute("listaCategoriaArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaCategoriaAccion", servicioCategoriaAccion.findAll());
		return "PrincipalUsuario";
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
