package com.salesianos.triana.dam.proyectofinalprueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	@Column(columnDefinition = "TEXT")
	private String direccionFacturacion;
	private String correo;
	private String contrasenia;
	@Builder.Default
	private boolean admin = false;
	@Builder.Default
	private boolean usuarioPremium = false;
}
