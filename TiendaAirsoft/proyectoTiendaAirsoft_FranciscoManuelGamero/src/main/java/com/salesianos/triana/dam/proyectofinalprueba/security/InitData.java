package com.salesianos.triana.dam.proyectofinalprueba.security;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.repository.UsuarioRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	/*
	@PostConstruct
	public void init() {
		
		Usuario usuario = Usuario.builder()
				.admin(false)
				.nombre("Cándida")
				.apellidos("Alcantarilla")
				.dni("1234567A")
				.direccionFacturacion("Calle Falsa 123")
				.correo("correo12@gmail.com")
				.nombreUsuario("user")
				//.password("1234")
				.contrasenia(passwordEncoder.encode("1234"))
				.build();
		
		Usuario admin = Usuario.builder()
				.admin(true)
				.nombre("Francisco")
				.apellidos("Gamero")
				.dni("87654321B")
				.direccionFacturacion("Calle verdadera 321")
				.correo("correo24@gmail.com")
				.nombreUsuario("admin")
				.contrasenia(passwordEncoder.encode("admin"))
				.build();
		
		repo.saveAll(List.of(usuario, admin));
		
	}
	*/
}