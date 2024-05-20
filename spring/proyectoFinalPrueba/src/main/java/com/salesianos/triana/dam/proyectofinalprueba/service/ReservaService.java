package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Reserva;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ReservaNoEncontrada;
import com.salesianos.triana.dam.proyectofinalprueba.repository.ReservaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class ReservaService extends BaseServiceImplementation<Reserva, Long, ReservaRepository>{

	public Reserva buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ReservaNoEncontrada("No se ha encontrado la reserva."));
	}
	
	public Integer contarReservas() {
		return repository.contarCantidadReservas();
	}
	public double calcularGananciasReservas() {
		return repository.calcularGananciasTotalesReserva();
	}
}
