package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Articulo;

@Repository
public interface ArticuloRepositorio extends CrudRepository<Articulo, Integer> {

	Articulo findById(Integer id);
	
}
