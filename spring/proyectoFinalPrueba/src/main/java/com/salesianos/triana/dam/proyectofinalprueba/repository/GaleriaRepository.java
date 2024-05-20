package com.salesianos.triana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Galeria;

public interface GaleriaRepository extends JpaRepository<Galeria, Long>{

	@Query("""
		    SELECT COUNT(r)
		    FROM 
		        Reserva r
		        LEFT JOIN r.galeria gal
		    WHERE 
		        gal = ?1
		""")
		public int hayGaleriaReservada(Galeria galeria);
}
