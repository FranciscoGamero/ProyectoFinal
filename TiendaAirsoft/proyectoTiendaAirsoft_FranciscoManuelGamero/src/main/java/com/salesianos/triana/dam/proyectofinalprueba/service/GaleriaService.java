package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Galeria;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.GaleriaNoEncontrada;
import com.salesianos.triana.dam.proyectofinalprueba.repository.GaleriaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class GaleriaService extends BaseServiceImplementation<Galeria, Long, GaleriaRepository>{

	public int hayUnaReserva(Galeria galeria) {
		return repository.hayGaleriaReservada(galeria);
	}
	public Galeria  buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new GaleriaNoEncontrada("No se ha encontrado el producto"));
	}
	
}
