package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Entity
public class Equipamiento extends Producto{
	
	private Talla talla;
	private String color;
}
