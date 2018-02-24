package com.tienda.online.servicio;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Usuario;
import com.tienda.online.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	public Usuario guardar(Usuario usuario) {
		usuario.setFecha(new Date());
		Usuario usuarioExiste = usuarioRepositorio.findByEmail(usuario.getEmail());
		if(usuarioExiste == null) {
			return usuarioRepositorio.save(usuario);
		}
		
		
		return null;
	}
	
	
	public List<Usuario> obtenerTodos(){
		return (List<Usuario>)usuarioRepositorio.findAll();
	}
	
	public long contar () {
		return usuarioRepositorio.count();
	}
	
	public void eliminar(Integer id) {
		usuarioRepositorio.delete(id);
	}
	
}
