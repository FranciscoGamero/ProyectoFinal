package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoNoEncontrado;
import com.salesianos.triana.dam.proyectofinalprueba.repository.VentaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class VentaService extends BaseServiceImplementation<Venta, Long, VentaRepository>{

	public List<Venta> BuscartodasLasVentasFinalizadas(){
		return repository.buscarTodasLasFinalizadas();
	}
	
	public boolean existeVentaNoFinalizada(Usuario usuario) {
		return this.repository.existeNoFinalizada(usuario);
	}

	public Optional<Venta> getVentaNoFinalizada(Usuario usuario){
		return this.repository.findByFinalizadaFalseAndComprador(usuario);
	}

	public boolean hayProductoEnCarrito(Venta carrito, Producto producto) {
		return this.repository.hayProductoEnCarrito(carrito, producto);
	}	
	public Venta buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ProductoNoEncontrado("No se ha encontrado el producto."));
	}
	public Integer contarVentas() {
		return repository.contarCantidadVentas();
	}
	public double calcularGananciasVentas() {
		return repository.calcularGananciasTotalesVentas();
	}
	public List<Usuario> usuariosQueMasHanGastado(){
		return repository.usuariosQueMasHanGastado();
	}
}
