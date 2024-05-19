package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Arma extends Producto{
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_arma_categoria_arma"))
	private CategoriaArma categoriaArma;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_arma_categoria_propulsion"))
	private CategoriaAccion formaDisparo;
	private int capacidadCargador;
	private boolean necesitaLicencia;
}
