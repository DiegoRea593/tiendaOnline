package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Rol;

@Repository
public interface RolRepositorio extends CrudRepository<Rol, Integer> {

	Rol findById(Integer id);
	

	//@Query("select p from Paquete p where p.codigo = ?1")
	//Paquete buscarPorCodigo(String codigo);
}
