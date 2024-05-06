package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.util.ArrayList;
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
		List<Producto> lista = new ArrayList<>();
		for (Producto p : findAll()) {
			if(p instanceof Arma) {
				lista.add(p);
			}
		}
		return lista;
	}
	public List<Producto> getListaEquipamiento(){
		List<Producto> lista = new ArrayList<>();
		for (Producto p : findAll()) {
			if(p instanceof Equipamiento) {
				lista.add(p);
			}
		}
		return lista;
	}
}
