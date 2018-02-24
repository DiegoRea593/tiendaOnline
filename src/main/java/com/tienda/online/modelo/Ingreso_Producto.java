package com.tienda.online.modelo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ingreso_Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer cantidad;
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	private BigDecimal total;
	@JoinColumn(name="articulo")
	@ManyToOne
	private Articulo arituclo;
	@JoinColumn(name="usuario")
	@ManyToOne
	private Usuario usuario;
	
	//Siempre colocar el constructor por default
	public Ingreso_Producto() {
		
	}
	
	public Ingreso_Producto(Integer id, Integer cantidad, Date fechaIngreso, BigDecimal total, Articulo arituclo,
			Usuario usuario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.total = total;
		this.arituclo = arituclo;
		this.usuario = usuario;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	/**
	 * @return the arituclo
	 */
	public Articulo getArituclo() {
		return arituclo;
	}
	/**
	 * @param arituclo the arituclo to set
	 */
	public void setArituclo(Articulo arituclo) {
		this.arituclo = arituclo;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
