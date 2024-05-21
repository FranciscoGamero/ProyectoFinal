package com.salesianos.triana.dam.proyectofinalprueba.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@IdClass(LineaVentaPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaVenta {

	@Id @GeneratedValue
	private Long id;
	
	@Id
	@ManyToOne
	private Venta venta;
	@ManyToOne
	private Producto producto;

	private int cantidad;
	
	public double getPrecioLineaVenta() {
		return producto.getPrecio() * cantidad;
	}

}
