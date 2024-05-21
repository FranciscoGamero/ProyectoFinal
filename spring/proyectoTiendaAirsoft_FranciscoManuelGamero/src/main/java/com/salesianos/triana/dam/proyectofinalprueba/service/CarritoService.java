package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;

@Service
public class CarritoService {

	@Autowired
	private VentaService ventaServicio;

	public Venta getCarrito(Usuario usuario) {
		return ventaServicio.getVentaNoFinalizada(usuario).orElseGet(() -> crearCarrito(usuario));
		
	}

	public void addProducto(Usuario usuario, Producto producto, int cantidad) {
		Venta carrito = getCarrito(usuario);
		if (!ventaServicio.hayProductoEnCarrito(carrito, producto)) {
			carrito.addLineaVenta(LineaVenta.builder()
					.venta(carrito)
					.producto(producto)
					.cantidad(cantidad)
					.build());
		} else {
			Optional<LineaVenta> lv = buscarPorProducto(usuario, producto);
			if (lv.isPresent()) {
				modificarCantidad(usuario, producto, lv.get().getCantidad() + 1);
			}
		}
		carrito.setImporteTotal(getImporteTotal(usuario));
		ventaServicio.edit(carrito);
	}

	public void eliminarProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);
		Optional<LineaVenta> aEliminar = buscarPorProducto(usuario, producto);
		if (aEliminar.isPresent()) {
			carrito.removeLineaVenta(aEliminar.get());
			carrito.setImporteTotal(getImporteTotal(usuario));
			ventaServicio.edit(carrito);
		}
	}

	public Optional<LineaVenta> buscarPorProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);

		return carrito.getListaLineasVentas().stream().filter(lv -> lv.getProducto().getId() == producto.getId()).findFirst();
	}

	public void modificarCantidad(Usuario usuario, Producto producto, int cantidad) {
		Venta carrito = getCarrito(usuario);

		if (cantidad <= 0) {
			eliminarProducto(usuario, producto);
			carrito.setImporteTotal(getImporteTotal(usuario));
		} else {
			Optional<LineaVenta> aMod = buscarPorProducto(usuario, producto);
			if (aMod.isPresent()) {
				LineaVenta lv = aMod.get();
				lv.setCantidad(cantidad);
				carrito.setImporteTotal(getImporteTotal(usuario));
				ventaServicio.edit(carrito);
			} else {
				addProducto(usuario, producto, cantidad);
			}
		}
	}

	public void finalizarCompra(Usuario usuario) {
		Venta carrito = getCarrito(usuario);
		carrito.setFinalizada(true);
		carrito.setFechaPedido(LocalDateTime.now());
		carrito.setImporteTotal(getImporteTotal(usuario));
		if(usuario.isUsuarioPremium()) {
			carrito.setImporteTotal(carrito.calcularImporteConDescuento());
		}
		ventaServicio.edit(carrito);
	}
	
	public boolean hayCarritoCreado(Usuario u) {
		return ventaServicio.existeVentaNoFinalizada(u);
	}
	public Venta crearCarrito(Usuario usuario) {
		Venta carrito = Venta.builder()
				.comprador(usuario)
				.finalizada(false)
				.build();
		ventaServicio.save(carrito);
		return carrito;
	}
	public List<LineaVenta> getProductosEnCarrito(Usuario us){
		return getCarrito(us).getListaLineasVentas();
	}
	public double getImporteTotal(Usuario usuario) {
		return getCarrito(usuario).getListaLineasVentas()
				.stream()
				.mapToDouble(LineaVenta::getPrecioLineaVenta)
				.sum();
	}
}