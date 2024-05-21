package com.salesianos.triana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.TipoGaleria;

public interface TipoGaleriaRepository extends JpaRepository<TipoGaleria, Long>{

	@Query("""
		    SELECT COUNT(r)
		    FROM 
		        Reserva r 
		        LEFT JOIN r.galeria gal
		    WHERE 
		        gal.tipo = ?1
		""")
		public int hayReservaHecha(TipoGaleria tipoGaleria);
}
