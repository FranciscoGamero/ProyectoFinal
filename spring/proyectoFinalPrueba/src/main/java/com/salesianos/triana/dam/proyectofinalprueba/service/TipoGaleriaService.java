package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.TipoGaleria;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.TipoGaleriaException;
import com.salesianos.triana.dam.proyectofinalprueba.repository.TipoGaleriaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class TipoGaleriaService extends BaseServiceImplementation<TipoGaleria, Long, TipoGaleriaRepository>{

	public TipoGaleria buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new TipoGaleriaException("No se ha encontrado el producto"));
	}
	public int hayUnaReserva(TipoGaleria tipo) {
		return repository.hayReservaHecha(tipo);
	}
}
