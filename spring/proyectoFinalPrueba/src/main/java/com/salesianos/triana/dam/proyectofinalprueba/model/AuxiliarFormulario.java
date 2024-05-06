package com.salesianos.triana.dam.proyectofinalprueba.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuxiliarFormulario {
	private Producto p;
	private Arma a;
	private Equipamiento e;
}
