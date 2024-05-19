package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Reserva {

	@Id 
	@GeneratedValue
	private long id;
		
	private double importeTotal;
	
	@ManyToOne
	private Usuario comprador;
	
	@ManyToOne
	private Galeria galeria;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime fechaInicioReserva; 
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime fechaFinReserva; 
	
	
	public double calcularImporteTotal() {
		return galeria.getPrecioHora() * (fechaFinReserva.getHour()-fechaInicioReserva.getHour());
	}
	
	public void establecerImporteTotal() {
		this.setImporteTotal(calcularImporteTotal());
	}
}
