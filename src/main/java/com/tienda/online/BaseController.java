package com.tienda.online;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.dto.response.ErrorResponse;
//Prueba
@RestController
public class BaseController {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return404(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		
		
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return409(DataIntegrityViolationException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
		
		
	}
}
