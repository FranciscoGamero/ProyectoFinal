package com.salesianos.triana.dam.proyectofinalprueba.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.repository.ArmaRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;


@Service
public class ArmaService extends BaseServiceImplementation<Arma, Long, ArmaRepository>{

	public Arma montarArma(Producto p, Arma a) {
		a.setNombre(p.getNombre());
		a.setDescripcion(p.getDescripcion());
		a.setMarca(p.getMarca());
		a.setImagen(p.getImagen());
		a.setPrecio(p.getPrecio());
		return a;
	}
	public List<Arma> buscarPorCategoriaArma(long id){
		return repository.findByCategoriaArmaId(id);
	}
	public List<Arma> buscarPorCategoriaAccion(long id){
		return repository.findByCategoriaAccionId(id);
	}
}
