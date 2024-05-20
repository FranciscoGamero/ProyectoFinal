package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Talla;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {

	
	//List<Equipamiento> findByColorAllIgnoreCase(String color);
	
	//List<Equipamiento> findByTallaAllIgnoreCase(Talla talla);
}
