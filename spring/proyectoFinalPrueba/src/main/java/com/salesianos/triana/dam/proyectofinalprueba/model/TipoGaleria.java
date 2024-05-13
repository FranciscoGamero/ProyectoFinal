package com.salesianos.triana.dam.proyectofinalprueba.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@OnDelete(action = OnDeleteAction.CASCADE)
public class TipoGaleria {
	@Id @GeneratedValue
	private long id;
	private String nombre;
	private double precioAgregado;
}
