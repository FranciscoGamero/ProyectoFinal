package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
//@Entity
public class Cuenta {
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String correo;
	private String contrasenia;
	private String direccionFacturacion;
	private String imagen;
	private TipoUsuario tipoUsuario;
}
