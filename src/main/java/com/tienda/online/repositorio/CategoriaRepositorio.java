package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends CrudRepository<Categoria, String> {

	Categoria findById(String id);
}
