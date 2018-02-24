package com.tienda.online.controlador;

import java.util.List;

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

import com.tienda.online.modelo.Articulo;
import com.tienda.online.servicio.ArticuloServicio;

@RestController
@RequestMapping("/articulo")
public class ArticuloControlador {
	
	private static Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);
	
	
	private ArticuloServicio articuloServicio;

	@Autowired
	public ArticuloControlador(ArticuloServicio articuloServicio) {
		super();
		this.articuloServicio = articuloServicio;
	}
	
	@PostMapping(produces="application/json")
	public Articulo guardar(@RequestBody @Validated Articulo articulo) {
		try
		{
			return articuloServicio.guardar(articulo);
		}catch(DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarArticulo: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@GetMapping(produces="application/json")
	public List<Articulo> obtenerTodos(){
		try {	
				return articuloServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosArticulo: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(Integer id) {
		try {
			articuloServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarArticulo: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
