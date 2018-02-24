package com.tienda.online.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Detalle_Compra;
import com.tienda.online.repositorio.Detalle_CompraRepositorio;

@Service
public class Detalle_CompraServicio {

	private Detalle_CompraRepositorio detalle_CompraRepositorio;

	
	@Autowired
	public Detalle_CompraServicio(Detalle_CompraRepositorio detalle_CompraRepositorio) {
		super();
		this.detalle_CompraRepositorio = detalle_CompraRepositorio;
	}
	
	public List<Detalle_Compra> obtenerTodos(){
		return (List<Detalle_Compra>) detalle_CompraRepositorio.findAll();
	}
	
	public Detalle_Compra guardar(Detalle_Compra detalle_Compra) {
		return detalle_CompraRepositorio.save(detalle_Compra);
	}
	
	public void eliminar(Integer id) {
		detalle_CompraRepositorio.delete(id);
	}
	
}
