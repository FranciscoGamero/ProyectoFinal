package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
//@Entity
public class CategoriaArma {

	private long id;
	
	private String nombre;
		
}