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

import com.tienda.online.modelo.Detalle_Compra;
import com.tienda.online.servicio.Detalle_CompraServicio;



@RestController
@RequestMapping("/detalle_compra")
public class Detalle_CompraControlador {
	
private static final Logger logger = LoggerFactory.getLogger(CategoriaControlador.class);
	
	private Detalle_CompraServicio detalle_CompraServicio;

	@Autowired
	public Detalle_CompraControlador(Detalle_CompraServicio detalle_CompraServicio) {
		super();
		this.detalle_CompraServicio = detalle_CompraServicio;
	}
	
	@GetMapping(produces="application/json")
	public List<Detalle_Compra> obtenerTodos(){
		try {
			return detalle_CompraServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Detalle_Compra guardar(@RequestBody @Validated Detalle_Compra detalle_Compra) {
		try {
			return detalle_CompraServicio.guardar(detalle_Compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			detalle_CompraServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
