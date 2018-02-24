package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Detalle_Compra;

@Repository
public interface Detalle_CompraRepositorio extends CrudRepository<Detalle_Compra, Integer>{
	Detalle_Compra findById(Integer id);
}
