package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

	@Id 
	@GeneratedValue
	private long id;
	
	@Builder.Default
	private LocalDate fechaCreacion = LocalDate.now(); 
	
	private Usuario comprador;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="venta", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<LineaDeVenta> lineaVenta = new ArrayList<>();
	
	public void addLineaVenta(LineaDeVenta linea) {
		linea.setVenta(this);
		this.lineaVenta.add(linea);
	}
	
	public void removeAsiento(LineaDeVenta linea) {
		this.lineaVenta.remove(linea);
		linea.setVenta(this);
	}
}
