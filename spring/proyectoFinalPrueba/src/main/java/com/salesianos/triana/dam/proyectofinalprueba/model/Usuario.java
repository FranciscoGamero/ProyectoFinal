package com.salesianos.triana.dam.proyectofinalprueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
//@Entity
public class Usuario {
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccionFacturacion;
	private String correo;
	private String contrasenia;
	@Builder.Default
	private String imagen = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png";
	@Builder.Default
	private boolean admin = false;
	@Builder.Default
	private boolean usuarioPremium = false;
}
