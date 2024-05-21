package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class ProductoService extends BaseServiceImplementation<Producto, Long, ProductoRepository>{
	
	public List<Producto> getListaArmas(){
		return findAll().stream().filter(p -> p instanceof Arma).toList();
	}
	public List<Producto> getListaEquipamiento(){
		return findAll().stream().filter(p -> p instanceof Equipamiento).toList();
	}

	public List<Producto> buscarPorNombre(String busqueda) {
        return this.repository.findByNombreContainsOrDescripcionContainsAllIgnoreCase(busqueda, busqueda);
	}
	public List<Producto> buscarMasNuevos(){
		return repository.buscarOrdenadosPorFecha();
	}
	public List<Producto> buscarMasBaratos(){
		return repository.buscarMasBaratos();
	}
}
