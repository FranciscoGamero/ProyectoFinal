package com.salesianos.triana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
    @Query("SELECT COUNT(r) FROM Reserva r")
    Integer contarCantidadReservas();
    
    @Query("SELECT SUM(r.importeTotal) FROM Reserva r")
    Double calcularGananciasTotalesReserva();
}
