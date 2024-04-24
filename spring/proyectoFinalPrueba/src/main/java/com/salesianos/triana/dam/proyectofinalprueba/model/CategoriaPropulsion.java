package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class CategoriaPropulsion {

	public CategoriaPropulsion(String string) {
		
	}

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
}
