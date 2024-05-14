package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("SELECT p FROM Producto p WHERE p.precio < ?1")
	public List<Producto> buscarMasBaratos(double precio);
}
