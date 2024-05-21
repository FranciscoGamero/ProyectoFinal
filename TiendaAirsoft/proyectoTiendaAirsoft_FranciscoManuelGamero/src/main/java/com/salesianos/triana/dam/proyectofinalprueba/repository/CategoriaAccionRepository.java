package com.salesianos.triana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaAccion;

public interface CategoriaAccionRepository extends JpaRepository<CategoriaAccion, Long>{

	@Query("""
		    SELECT COUNT(v)
		    FROM 
		        Venta v 
		        LEFT JOIN v.listaLineasVentas lv 
		    WHERE 
		        lv.producto.formaDisparo = ?1
		""")
		public int hayAccionUsada(CategoriaAccion categoriaAccion);
}
