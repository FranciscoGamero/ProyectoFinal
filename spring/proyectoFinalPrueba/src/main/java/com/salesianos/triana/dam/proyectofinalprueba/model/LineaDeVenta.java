package com.salesianos.triana.dam.proyectofinalprueba.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@OnDelete(action = OnDeleteAction.CASCADE)
public class LineaDeVenta {

	@Id @GeneratedValue
	private Long id;
	
	@Id
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Venta venta;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Producto producto;
	

	private int Cantidad;

}
