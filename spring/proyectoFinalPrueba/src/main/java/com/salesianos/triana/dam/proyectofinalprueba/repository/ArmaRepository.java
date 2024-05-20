package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Long>{

	@Query("SELECT a FROM Arma a WHERE a.categoriaArma.id = ?1")
	List<Arma> findByCategoriaArmaId(long idCategoriaArma);
	
	@Query("SELECT a FROM Arma a WHERE a.categoriaAccion.id = ?1")
	List<Arma> findByCategoriaAccionId(long idCategoriaAccion);
}
