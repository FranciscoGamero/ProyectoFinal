package com.salesianos.triana.dam.proyectofinalprueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.proyectofinalprueba.model.Equipamiento;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByNombreUsuario(String username);
	
	@Query("""
		    SELECT COUNT(v)
		    FROM 
		        Venta v 
		    WHERE 
		        v.comprador = ?1
		""")
		public int hayUsuarioConVenta(Usuario usuario);
}
