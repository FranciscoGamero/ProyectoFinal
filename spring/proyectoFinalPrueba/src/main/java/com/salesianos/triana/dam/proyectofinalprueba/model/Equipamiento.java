package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Entity
@Data
public class Equipamiento extends Producto{
	
	@Enumerated(EnumType.STRING)
	private List<Talla> tallasDisponibles;
	private String color;
	
}