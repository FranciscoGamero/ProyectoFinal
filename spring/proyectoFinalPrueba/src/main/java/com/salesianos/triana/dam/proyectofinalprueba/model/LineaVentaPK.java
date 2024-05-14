package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaVentaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Venta venta;
	private Long id;
}
