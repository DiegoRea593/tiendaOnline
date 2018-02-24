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

import com.tienda.online.modelo.Ingreso_Producto;
import com.tienda.online.servicio.Ingreso_ProductoServicio;

@RestController
@RequestMapping("/ingreso_producto")
public class Ingreso_ProductoControlador {

	private static final Logger logger = LoggerFactory.getLogger(CategoriaControlador.class);
	
	private Ingreso_ProductoServicio ingreso_ProductoServicio;

	@Autowired
	public Ingreso_ProductoControlador(Ingreso_ProductoServicio ingreso_ProductoServicio) {
		super();
		this.ingreso_ProductoServicio = ingreso_ProductoServicio;
	}
	
	
	@GetMapping(produces="application/json")
	public List<Ingreso_Producto> obtenerTodos(){
		try {
			return ingreso_ProductoServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Ingreso_Producto guardar(@RequestBody @Validated Ingreso_Producto ingreso_Producto) {
		try {
			return ingreso_ProductoServicio.guardar(ingreso_Producto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			ingreso_ProductoServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
}
