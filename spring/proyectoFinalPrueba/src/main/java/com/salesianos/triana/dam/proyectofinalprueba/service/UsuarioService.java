package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianos.triana.dam.proyectofinalprueba.model.Usuario;
import com.salesianos.triana.dam.proyectofinalprueba.model.Venta;
import com.salesianos.triana.dam.proyectofinalprueba.repository.UsuarioRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service	
public class UsuarioService extends BaseServiceImplementation<Usuario, Long, UsuarioRepository>{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario save(Usuario u) {
		u.setContrasenia(passwordEncoder.encode(u.getContrasenia()));
		return super.save(u);
	}
	public double gastoTotal(Usuario usuario) {
		return usuario.getListaVentas()
				.stream()
				.mapToDouble(Venta::getImporteTotal)
				.sum();
	}
	public void establecerVIP(Usuario usuario, double minimo) {
		if (gastoTotal(usuario)>minimo) {
			usuario.setUsuarioPremium(true);
		}
	}
}
