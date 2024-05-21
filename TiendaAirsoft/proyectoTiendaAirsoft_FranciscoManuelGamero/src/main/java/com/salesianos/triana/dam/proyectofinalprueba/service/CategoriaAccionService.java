package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaAccion;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.CategoriaAccionNoEncontrada;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoNoEncontrado;
import com.salesianos.triana.dam.proyectofinalprueba.repository.CategoriaAccionRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class CategoriaAccionService extends BaseServiceImplementation<CategoriaAccion, Long,CategoriaAccionRepository>{

	public CategoriaAccion buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CategoriaAccionNoEncontrada("No se ha encontrado la categoría."));
	}
	public int hayUnaVenta(CategoriaAccion categoriaAccion) {
		return repository.hayAccionUsada(categoriaAccion);
	}
}
