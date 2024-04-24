package com.salesianos.triana.dam.proyectofinalprueba.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.salesianos.triana.dam.proyectofinalprueba.model.Arma;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaArma;
import com.salesianos.triana.dam.proyectofinalprueba.model.CategoriaPropulsion;


@Service
public class ArmaService {

	public List<Arma> getLista() {
		return Arrays.asList(
				new Arma(1,"Beretta 90two", "Una pistola semiautomática confiable y precisa.", "https://static4.gunfire.com/spa_pm_Pistola-de-airsoft-Beretta-90two-1152203895_1.webp",
						499.99, new CategoriaArma(1,"Pistola"), new CategoriaPropulsion(1,"Muelle"), 8, false),
				new Arma(2,"Silverback SRS A1 22 Inch - OD", "El Silverback SRS-A1 22” es una versión con licencia completa del rifle de francotirador bullpup Desert Tech Scout Recon Stealth A1.",
						"https://www.replicantairsoft.com/webshop/14707-large_default/silverback-srs-a1-22-inch-od-silverback-airsoft.jpg", 502.50, new CategoriaArma(2,"Francotirador"), new CategoriaPropulsion(3,"Gas"), 5, true),
				new Arma(3,"SAIGA 12K Gas Blow Back Shotgun", "Una escopeta potente para combates cercanos.", "https://www.replicantairsoft.com/webshop/13774-large_default/saiga-12k-gas-blow-back-shotgun-tokyo-marui.jpg",
						799.99,new CategoriaArma(3,"Escopeta"), new CategoriaPropulsion(3,"Electrica"), 7, true));
	}
}
