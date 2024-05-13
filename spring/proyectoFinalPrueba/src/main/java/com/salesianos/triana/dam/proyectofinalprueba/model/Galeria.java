package com.salesianos.triana.dam.proyectofinalprueba.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Galeria {
	@Id @GeneratedValue
	private long id;
	private String descripcion;
	private String imagen;
	private double precioHora;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_galeria_tipo_galeria"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TipoGaleria tipo;
	private int cantPersonas;
}
