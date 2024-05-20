package com.salesianos.triana.dam.proyectofinalprueba.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {

	
	List<Equipamiento> findByColorIgnoreCase(String color);
	
	@Query("""
		    SELECT COUNT(v)
		    FROM 
		        Venta v 
		        LEFT JOIN v.listaLineasVentas lv 
		    WHERE 
		        lv.producto = ?1
		""")
		public int hayEquipamientoVendido(Equipamiento equipamiento);
}
