package com.tienda.online.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Articulo;
import com.tienda.online.repositorio.ArticuloRepositorio;

@Service
public class ArticuloServicio {

	private ArticuloRepositorio articuloRepositorio;

	@Autowired
	public ArticuloServicio(ArticuloRepositorio articuloRepositorio) {
		super();
		this.articuloRepositorio = articuloRepositorio;
	}
	
	public List<Articulo> obtenerTodos(){
		return (List<Articulo>) articuloRepositorio.findAll();
	}
	
	public Articulo guardar(Articulo articulo) {
		return articuloRepositorio.save(articulo);
	}
	
	public void eliminar(Integer id) {
		articuloRepositorio.delete(id);
	}
	
}
