package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
		return ventaServicio.getVentaNoFinalizada(usuario).orElseGet(() -> new Venta());
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
		ventaServicio.edit(carrito);
	}

	public void eliminarProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);
		Optional<LineaVenta> aEliminar = buscarPorProducto(usuario, producto);
		if (aEliminar.isPresent()) {
			carrito.removeLineaVenta(aEliminar.get());
			ventaServicio.save(carrito);
		}
	}

	public Optional<LineaVenta> buscarPorProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);

		return carrito.getLineaVenta().stream().filter(lv -> lv.getProducto().getId() == producto.getId()).findFirst();
	}

	public void modificarCantidad(Usuario usuario, Producto producto, int cantidad) {
		Venta carrito = getCarrito(usuario);

		if (cantidad <= 0) {
			eliminarProducto(usuario, producto);
		} else {
			Optional<LineaVenta> aMod = buscarPorProducto(usuario, producto);
			if (aMod.isPresent()) {
				LineaVenta lv = aMod.get();
				lv.setCantidad(cantidad);
				ventaServicio.edit(carrito);
			} else {
				addProducto(usuario, producto, cantidad);
			}
		}
	}

	public void finalizarCompra(Usuario us) {
		Venta carrito = getCarrito(us);
		carrito.setFinalizada(true);
		carrito.setFechaPedido(LocalDateTime.now());
		carrito.setImporteTotal(getImporteTotal(us));
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
		return carrito;
	}
	/*
	public Map<Producto,Integer> getProductosEnCarrito(Usuario us){
		return getCarrito(us)
				.getLineaVenta()
				.stream()
				.collect(Collectors.toMap(lv -> lv.getProducto(), lv -> lv.getCantidad()));
	}
	*/
	public Map<Producto,Integer> getProductosEnCarrito(Usuario us){
	    Venta carrito = getCarrito(us);
	    System.out.println(us);

	    Map<Producto,Integer> productosEnCarrito = carrito.getLineaVenta()
	            .stream()
	            .collect(Collectors.toMap(
	                    lv -> lv.getProducto(),
	                    lv -> lv.getCantidad()));

	    // Imprimir los productos recuperados del carrito
	    System.out.println("Productos en el carrito:");
	    for (Map.Entry<Producto, Integer> entry : productosEnCarrito.entrySet()) {
	        Producto producto = entry.getKey();
	        Integer cantidad = entry.getValue();
	        System.out.println("Producto: " + producto.getNombre() + ", Cantidad: " + cantidad);
	    }

	    return productosEnCarrito;
	}
	public double getImporteTotal(Usuario usuario) {
		return getCarrito(usuario).getLineaVenta()
				.stream()
				.mapToDouble(LineaVenta::getPrecioLineaVenta)
				.sum();
	}
}