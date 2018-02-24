package com.tienda.online.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{
	
	Usuario findById(Integer id);
	Usuario findByEmail(String mail);

}
