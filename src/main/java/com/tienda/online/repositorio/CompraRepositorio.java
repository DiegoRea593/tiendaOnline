package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Compra;

@Repository
public interface CompraRepositorio extends CrudRepository<Compra, Integer>{
	
	Compra findById(Integer id);

}
