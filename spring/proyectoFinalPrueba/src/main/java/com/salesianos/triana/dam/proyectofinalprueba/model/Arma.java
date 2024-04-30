package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Arma {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	private String marca;
	@Column(columnDefinition = "VARCHAR (500)")
	private String imagen;
	private double precio;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_arma_categoria_arma"))
	private CategoriaArma categoriaArma;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_arma_categoria_propulsion"))
	private CategoriaAccion formaDisparo;
	private int capacidadCargador;
	private boolean necesitaLicencia;
}
