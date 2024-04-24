package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Galeria {
	private boolean llevaEquipamiento;// Ver si el precio del equipamiento va aqui como atributo o si se pone uno base
	private LocalDate dia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private double precioHora;
	private int cantPersonas;
}
