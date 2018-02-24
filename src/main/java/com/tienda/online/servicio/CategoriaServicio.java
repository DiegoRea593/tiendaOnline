package com.tienda.online.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Categoria;
import com.tienda.online.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicio {

	private CategoriaRepositorio categoriaRepositorio;

	@Autowired
	public CategoriaServicio(CategoriaRepositorio categoriaRepositorio) {
		super();
		this.categoriaRepositorio = categoriaRepositorio;
	}
	
	public List<Categoria> obtenerTodos(){
		return (List<Categoria>) categoriaRepositorio.findAll();
	}
	
	public Categoria guardar(Categoria categoria) {
			return categoriaRepositorio.save(categoria);		
	}
	
	public long contar() {
		return categoriaRepositorio.count();
	}
	
	public void eliminar(String id) {
		categoriaRepositorio.delete(id);
	}
	
	
}
