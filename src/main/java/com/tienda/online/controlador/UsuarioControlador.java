package com.tienda.online.controlador;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.BaseController;
import com.tienda.online.modelo.Usuario;
import com.tienda.online.servicio.UsuarioServicio;


@RestController
@RequestMapping("/usuario")
public class UsuarioControlador extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);
	
	private UsuarioServicio usuarioServicio;

	@Autowired
	public UsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@PostMapping(produces="application/json")
	public Usuario guardar(@RequestBody @Validated Usuario usuario) {
		try
		{
			Usuario nuevoUsuario = usuarioServicio.guardar(usuario);
			if(nuevoUsuario == null) {
				throw new DataIntegrityViolationException("Ya existe un usuario con ese email");
			}
			return nuevoUsuario;
		}catch(DataIntegrityViolationException e) {
		//	logger.info("Error en el consumo del servicio guardarUsuario: " + e.getMessage());
			//throw new DataIntegrityViolationException(e.getMessage());

			logger.info("Error en el consumo del servicio guardarUsuario"+e.getMessage());
			throw new NoSuchElementException("Error en el consumo del servicio guardar:");
			//logger.info("Error en el consumo del servicio guardarUsuario"+e.getMessage());
			
		}
		
		
		
		
		
	}
	
	@GetMapping(produces="application/json")
	public List<Usuario> obtenerTodos(){
		try {	
				return usuarioServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosUsuario: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(Integer id) {
		try {
			usuarioServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarUsuario: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

	
}
