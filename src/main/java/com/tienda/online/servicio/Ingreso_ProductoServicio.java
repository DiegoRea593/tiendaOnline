package com.tienda.online.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Ingreso_Producto;
import com.tienda.online.repositorio.Ingreso_ProductoRepositorio;

@Service
public class Ingreso_ProductoServicio {
	
	private Ingreso_ProductoRepositorio ingreso_ProductoRepositorio;

	@Autowired
	public Ingreso_ProductoServicio(Ingreso_ProductoRepositorio ingreso_ProductoRepositorio) {
		super();
		this.ingreso_ProductoRepositorio = ingreso_ProductoRepositorio;
	}
	
	
	public List<Ingreso_Producto> obtenerTodos(){
		return (List<Ingreso_Producto>) ingreso_ProductoRepositorio.findAll();
	}
	
	public Ingreso_Producto guardar(Ingreso_Producto ingreso_Producto) {
		return ingreso_ProductoRepositorio.save(ingreso_Producto);
	}
	
	public void eliminar(Integer id) {
		ingreso_ProductoRepositorio.delete(id);
	}
	
}
