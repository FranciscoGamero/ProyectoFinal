package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("""
		    SELECT COUNT(lv) > 0
		    FROM 
		        Venta v 
		        LEFT JOIN v.listaLineasVentas lv 
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
	
	   @Query("""
		        SELECT v.comprador 
		        FROM Venta v 
		        WHERE v.finalizada = true 
		        GROUP BY v.comprador 
		        ORDER BY SUM(v.importeTotal) DESC
		        LIMIT 3
		    """)
		    List<Usuario> usuariosQueMasHanGastado();
	   
	   @Query("""
		        SELECT lv.producto 
		        FROM Venta v 
		        JOIN v.listaLineasVentas lv 
		        WHERE v.finalizada = true 
		        GROUP BY lv.producto 
		        ORDER BY SUM(lv.cantidad) DESC
		    """)
		    List<Producto> productoMasVendido();
	   
	    @Query("SELECT SUM(v.importeTotal) FROM Venta v WHERE v.finalizada = true")
	    Double calcularGananciasTotalesVentas();
	    
	    @Query("SELECT COUNT(v) FROM Venta v WHERE v.finalizada = true")
	    Integer contarCantidadVentas();
}
