package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("""
		    SELECT 
		        CASE WHEN COUNT(lv) > 0 THEN true ELSE false END
		    FROM 
		        Venta v 
		        LEFT JOIN v.lineaVenta lv 
		    WHERE 
		        v = ?1 
		        AND lv.producto = ?2
		""")
		public boolean hayProductoEnCarrito(Venta venta, Producto producto);

	
	public Optional<Venta> findFirstByFinalizadaFalseAndComprador(Usuario usuario);
	
	
	@Query("""
		    SELECT 
		        CASE WHEN v.finalizada = true THEN true ELSE false END
		    FROM 
		        Venta v
		    WHERE
			   v.comprador = ?1
			""")
	public boolean existeNoFinalizada(Usuario usuario);
}
