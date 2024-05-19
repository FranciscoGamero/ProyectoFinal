package com.salesianos.triana.dam.proyectofinalprueba.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	@Column(columnDefinition = "TEXT")
	private String direccionFacturacion;
	private String correo;
	private String nombreUsuario;
	private String contrasenia;
	@Builder.Default
	private boolean admin = false;
	@Builder.Default
	private boolean usuarioPremium = false;
	@Builder.Default
	private boolean activo=true;
	private String imagen;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="comprador", 
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Venta> listaVentas = new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="comprador", 
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Reserva> listaReservas = new ArrayList<>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getContrasenia();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getNombreUsuario();
	}
}
