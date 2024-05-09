package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetallesDeUsuaroServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repoUsuario.findFirstByNombreUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}
}
