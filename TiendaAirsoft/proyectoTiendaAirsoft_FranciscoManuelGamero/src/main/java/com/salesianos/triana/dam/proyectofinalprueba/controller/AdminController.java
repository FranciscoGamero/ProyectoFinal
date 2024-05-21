package com.salesianos.triana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaAccionService;
import com.salesianos.triana.dam.proyectofinalprueba.service.CategoriaArmaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.ReservaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.TipoGaleriaService;
import com.salesianos.triana.dam.proyectofinalprueba.service.UsuarioService;
import com.salesianos.triana.dam.proyectofinalprueba.service.VentaService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoriaAccionService servicioCategoriaAccion;
	@Autowired
	private CategoriaArmaService servicioCategoriaArma;
	@Autowired
	private TipoGaleriaService servicioTipoGaleria;
	@Autowired
	private UsuarioService servicioUsuario;
	@Autowired
	private VentaService servicioVenta;
	@Autowired
	private ReservaService servicioReserva;
	
	@GetMapping("/verTablaTipos")
	public String mostrarTablaTipos(Model model) {
		model.addAttribute("listaTipoArma", servicioCategoriaArma.findAll());
		model.addAttribute("listaTipoAccion", servicioCategoriaAccion.findAll());
		return "admin/menuTipos";
	}
	@GetMapping("/tiposGaleria")
	public String mostrarTablaTiposGaleria(Model model) {
		model.addAttribute("listaTipoGaleria", servicioTipoGaleria.findAll());
		return "admin/menuTiposGaleria";
	}
	
	@GetMapping("/usuarios")
	public String listaUsuarios(Model model) {
		model.addAttribute("listaUsuario", servicioUsuario.findAll());
		return "admin/menuUsuarios";
	}
	@GetMapping("/verListaVentas")
	public String listaVentas(Model model) {
		model.addAttribute("listaVentas", servicioVenta.BuscartodasLasVentasFinalizadas());
		return "admin/menuVentas";
	}
	@GetMapping("/verListaReservas")
	public String listaReservas(Model model) {
		model.addAttribute("listaReservas", servicioReserva.findAll());
		return "admin/menuReservas";
	}
	@GetMapping("/estadisticas")
	public String verEstadisticas(Model model) {
		model.addAttribute("contarReservas", servicioReserva.contarReservas());
		model.addAttribute("contarVentas",servicioVenta.contarVentas());
		model.addAttribute("listaUsuarios", servicioVenta.usuariosQueMasHanGastado());
		model.addAttribute("gananciasTotales", servicioReserva.calcularGananciasReservas()+servicioVenta.calcularGananciasVentas());
		return "admin/menuEstadisticas";
	}
}
