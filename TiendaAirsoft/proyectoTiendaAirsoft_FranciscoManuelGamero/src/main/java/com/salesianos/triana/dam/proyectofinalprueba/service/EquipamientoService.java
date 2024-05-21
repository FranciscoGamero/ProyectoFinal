package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Talla;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoAsociadoAVenta;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoNoEncontrado;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.UsuarioNoEncontrado;
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
		e.setFechaIngreso(LocalDate.now());
		return e;
	}
	public List<Equipamiento> buscarPorTalla(Talla talla){
		System.out.println(talla);

		return findAll().stream().filter(e -> e.getTallasDisponibles().contains(talla)).toList();
		
	}
	public List<Equipamiento> buscarPorColor(String color){
		return this.repository.findByColorIgnoreCase(color);
	}
	
	
	public int hayUnaVenta(Equipamiento equip) {
		return repository.hayEquipamientoVendido(equip);
	}
	public Equipamiento buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new UsuarioNoEncontrado("No se ha encontrado el producto"));
	}
}
