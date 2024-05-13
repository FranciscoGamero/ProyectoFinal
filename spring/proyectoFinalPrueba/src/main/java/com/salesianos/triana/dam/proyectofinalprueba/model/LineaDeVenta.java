package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaDeVenta {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Venta venta;
	private int Cantidad;

}
