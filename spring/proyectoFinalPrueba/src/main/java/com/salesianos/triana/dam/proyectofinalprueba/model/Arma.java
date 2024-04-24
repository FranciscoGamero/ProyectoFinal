package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
//@Entity
public class Arma {
	
	private long id;
	
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private CategoriaArma categoriaArma;
	private CategoriaPropulsion formaDisparo;
	private int capacidadCargador;
	private boolean necesitaLicencia;
	
	public Arma(String nombre, String descripcion, String imagen, double precio, CategoriaArma categoriaArma,
			CategoriaPropulsion formaDisparo, int capacidadCargador, boolean necesitaLicencia) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.categoriaArma = categoriaArma;
		this.formaDisparo = formaDisparo;
		this.capacidadCargador = capacidadCargador;
		this.necesitaLicencia = necesitaLicencia;
	}
}
