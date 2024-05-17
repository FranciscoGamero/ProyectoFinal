package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaVentaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private Venta venta;
	private Long id;
}
