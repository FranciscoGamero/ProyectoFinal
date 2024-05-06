package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.repository.EquipamientoRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service	
public class EquipamientoService extends BaseServiceImplementation<Equipamiento, Long, EquipamientoRepository>{
	
	public Equipamiento montarEquipamiento(Producto p, Equipamiento e) {
		e.setNombre(p.getNombre());
		e.setDescripcion(p.getDescripcion());
		e.setMarca(p.getMarca());
		e.setImagen(p.getImagen());
		e.setPrecio(p.getPrecio());
		return e;
	}
	
}
