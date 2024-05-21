package com.salesianos.triana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;



public interface CategoriaArmaRepository extends JpaRepository<CategoriaArma, Long>{

	@Query("""
		    SELECT COUNT(v)
		    FROM 
		        Venta v 
		        LEFT JOIN v.listaLineasVentas lv 
		    WHERE 
		        lv.producto.categoriaArma = ?1
		""")
		public int hayAccionUsada(CategoriaArma categoriaArma);
}
