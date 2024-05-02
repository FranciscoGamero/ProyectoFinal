package com.salesianos.triana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.proyectofinalprueba.model.Producto;
import com.salesianos.triana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianos.triana.dam.proyectofinalprueba.service.base.BaseServiceImplementation;

@Service
public class ProductoService extends BaseServiceImplementation<Producto, Long, ProductoRepository>{

}
