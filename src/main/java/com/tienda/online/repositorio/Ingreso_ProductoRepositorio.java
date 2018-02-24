package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Ingreso_Producto;

@Repository
public interface Ingreso_ProductoRepositorio extends CrudRepository<Ingreso_Producto, Integer>{

}
