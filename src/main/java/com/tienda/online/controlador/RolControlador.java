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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Rol;
import com.tienda.online.servicio.RolServicio;


@RestController
@RequestMapping("/rol")
public class RolControlador {
	
	private static final Logger  logger = LoggerFactory.getLogger(RolControlador.class);
	
	private RolServicio rolServicio;

	@Autowired
	public RolControlador(RolServicio rolServicio) {
		super();
		this.rolServicio = rolServicio;
	}
	
	
	@PostMapping(produces="application/json")
	public Rol guardar(@RequestBody @Validated Rol rol) {
		try {
			return rolServicio.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardaPaquete: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@GetMapping(produces="application/json")
	public List<Rol> obtenerTodos(){
		try {
			return rolServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosRol: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	
	}
	
	@PutMapping(produces="application/json")
	public Rol actualizar(@RequestBody @Validated Rol rol) {
		try {
			return rolServicio.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizarPaquete: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			rolServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarPaquete: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	
}
