package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH-MM-ss")
	private LocalDateTime fechaPedido; 
	
	@ManyToOne
	private Usuario comprador;
	
	@Builder.Default
	private boolean finalizada = false;
	
	@Builder.Default
	private double importeTotal = 0;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="venta", 
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = true
	)
	private List<LineaVenta> lineaVenta = new ArrayList<>();
	
	public void addLineaVenta(LineaVenta linea) {
		linea.setVenta(this);
		this.lineaVenta.add(linea);
	}
	
	public void removeLineaVenta(LineaVenta linea) {
		this.lineaVenta.remove(linea);
	}
}
