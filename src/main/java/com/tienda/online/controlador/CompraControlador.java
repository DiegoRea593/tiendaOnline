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

import com.tienda.online.modelo.Compra;
import com.tienda.online.servicio.CompraServicio;

@RestController
@RequestMapping("/compra")
public class CompraControlador {

	private static final Logger logger = LoggerFactory.getLogger(CategoriaControlador.class);
	
	private CompraServicio compraServicio;

	@Autowired
	public CompraControlador(CompraServicio compraServicio) {
		super();
		this.compraServicio = compraServicio;
	}
	
	@GetMapping(produces="application/json")
	public List<Compra> obtenerTodos(){
		try {
			return compraServicio.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Compra guardar(@RequestBody @Validated Compra compra) {
		try {
			return compraServicio.guardar(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			compraServicio.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	
}
