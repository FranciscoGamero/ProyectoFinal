package com.salesianos.triana.dam.proyectofinalprueba.service;



import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.ProductoNoEncontrado;
import com.salesianos.triana.dam.proyectofinalprueba.model.exception.VentaNoEncontrada;
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
		a.setFechaIngreso(LocalDate.now());
		return a;
	}
	public List<Arma> buscarPorCategoriaArma(long id){
		return repository.findByCategoriaArmaId(id);
	}
	public List<Arma> buscarPorCategoriaAccion(long id){
		return repository.findByCategoriaAccionId(id);
	}
	public int hayUnaVenta(Arma arma) {
		return repository.hayArmaVendida(arma);
	}
	public Arma buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new VentaNoEncontrada("No se ha encontrado el producto."));
	}
}
