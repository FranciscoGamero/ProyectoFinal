package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {
	
	@Id 
	@GeneratedValue
	private long id;
	
	private String nombre;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	private String marca;
	@Column(columnDefinition = "VARCHAR (500)")
	private String imagen;
	private double precio;
	private LocalDate fechaIngreso;
}
