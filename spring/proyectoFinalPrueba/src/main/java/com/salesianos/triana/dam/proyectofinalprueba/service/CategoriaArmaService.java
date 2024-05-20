package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoNoEncontrado;
import com.salesianos.triana.dam.proyectofinalprueba.repository.CategoriaArmaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class CategoriaArmaService extends BaseServiceImplementation<CategoriaArma, Long, CategoriaArmaRepository>{

	public CategoriaArma buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ProductoNoEncontrado("No se ha encontrado la categoría."));
	}
	public int hayUnaVenta(CategoriaArma categoriaArma) {
		return repository.hayAccionUsada(categoriaArma);
	}
}
