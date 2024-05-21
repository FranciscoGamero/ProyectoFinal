package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("SELECT p FROM Producto p ORDER BY p.precio ASC")
	public List<Producto> buscarMasBaratos();
	
	List<Producto> findByNombreContainsOrDescripcionContainsAllIgnoreCase(String nombre, String descripcion);
	
	@Query("SELECT p FROM Producto p ORDER BY p.fechaIngreso DESC")
    public List<Producto> buscarOrdenadosPorFecha();
}
