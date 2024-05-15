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
	
	@Builder.Default
	@DateTimeFormat(pattern = "dd-MM-yyyy HH-MM-ss")
	private LocalDateTime fechaCreacion = LocalDateTime.now(); 
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
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
	
	public void removeLineaVenta(LineaDeVenta linea) {
		this.lineaVenta.remove(linea);
		linea.setVenta(this);
	}
}
