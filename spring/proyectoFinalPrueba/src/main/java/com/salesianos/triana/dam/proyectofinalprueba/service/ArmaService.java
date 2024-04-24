package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaPropulsion;


@Service
public class ArmaService {

	public List<Arma> getLista() {
		return Arrays.asList(
				new Arma("Pistola Beretta", "Una pistola semiautomática confiable y precisa.", "imagen_pistola.png",
						499.99, new CategoriaArma("Pistola"), new CategoriaPropulsion("Muelle"), 8, false),
				new Arma("Silverback SRS A1 22 Inch - OD", "El Silverback SRS-A1 22” es una versión con licencia completa del rifle de francotirador bullpup Desert Tech Scout Recon Stealth A1.",
						"imagen_rifle.png", 502.50, new CategoriaArma("Francotirador"), new CategoriaPropulsion("Gas"), 5, true),
				new Arma("SAIGA 12K Gas Blow Back Shotgun", "Una escopeta potente para combates cercanos.", "imagen_escopeta.png",
						799.99,new CategoriaArma("Escopeta"), new CategoriaPropulsion("Electrica"), 7, true));
	}
}
