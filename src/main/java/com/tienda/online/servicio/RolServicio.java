package com.tienda.online.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Rol;
import com.tienda.online.repositorio.RolRepositorio;

@Service
public class RolServicio {
	
	private RolRepositorio rolRepositorio;

	@Autowired
	public RolServicio(RolRepositorio rolRepositorio) {
		super();
		this.rolRepositorio = rolRepositorio;
	}
	
		
	public Rol guardar(Rol rol) {
		return rolRepositorio.save(rol);
	}
	
	public List<Rol> obtenerTodos(){
		return (List<Rol>) rolRepositorio.findAll();
			
	}
	
	public long contar() {
		return rolRepositorio.count();
	}
	
	public void eliminar(Integer id) {
		rolRepositorio.delete(id);
	}
	
}
