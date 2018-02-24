package com.tienda.online.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Categoria;
import com.tienda.online.servicio.CategoriaServicio;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

	private static final Logger logger = LoggerFactory.getLogger(CategoriaControlador.class); 
	
	
	private CategoriaServicio categoriaServicio;

	@Autowired
	public CategoriaControlador(CategoriaServicio categoriaServicio) {
		super();
		this.categoriaServicio = categoriaServicio;
	}
	
	@GetMapping(produces="application/json")
	public List<Categoria> obtenerTodos(){
		try {
		return categoriaServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosCategoria: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PostMapping(produces="application/json")
	public Categoria guardar(@RequestBody @Validated Categoria categoria) {
		try {
			return categoriaServicio.guardar(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardaCategoria: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") String id) {
		try {
		categoriaServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarCategoria: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
}
