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
		    SELECT COUNT(lv) > 0
		    FROM 
		        Venta v 
		        LEFT JOIN v.lineaVenta lv 
		    WHERE 
		        v = ?1 
		        AND lv.producto = ?2
		""")
		public boolean hayProductoEnCarrito(Venta venta, Producto producto);

	@Query("""
			   SELECT v
			    FROM Venta v 
			    WHERE v.finalizada = false 
			    AND v.comprador = ?1
				""")
	public Optional<Venta> findByFinalizadaFalseAndComprador(Usuario usuario);
	
	
	@Query("""
		   SELECT COUNT(v) > 0 
		    FROM Venta v 
		    WHERE v.finalizada = false 
		    AND v.comprador = ?1
			""")
	public boolean existeNoFinalizada(Usuario usuario);
}
