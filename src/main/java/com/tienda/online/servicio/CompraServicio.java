package com.tienda.online.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Compra;
import com.tienda.online.repositorio.CompraRepositorio;

@Service
public class CompraServicio {

	private CompraRepositorio compraRepositorio;

	@Autowired
	public CompraServicio(CompraRepositorio compraRepositorio) {
		super();
		this.compraRepositorio = compraRepositorio;
	}
	
	public List<Compra> obtenerTodos(){
		return (List<Compra>) compraRepositorio.findAll();
	}
	
	public Compra guardar(Compra compra) {
		compra.setFecha(new Date());
		compra.setNroDocumento("000000"+ compraRepositorio.count()+1);
		compra.getListaDetalleCompra().forEach(detalle ->{
			detalle.setCompra(compra);
		});
		return compraRepositorio.save(compra);
	}
	
	public void eliminar(Integer id) {
		compraRepositorio.delete(id);
	}
	
}
