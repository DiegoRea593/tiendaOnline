package com.tienda.online.modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date fecha;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	@Column(name = "nro_documento")
	private String nroDocumento;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	private List<Detalle_Compra> listaDetalleCompra;
	
	
	//Siempre colocar el constructor por default
	public Compra() {
		
	}
	
	public Compra(Integer id, Date fecha, BigDecimal subtotal, BigDecimal iva, BigDecimal total, String nroDocumento,
			Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.nroDocumento = nroDocumento;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param date the fecha to set
	 */
	public void setFecha(Date  date) {
		this.fecha = date;
	}

	/**
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the iva
	 */
	public BigDecimal getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(BigDecimal iva) {
		this.iva = iva;
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
	 * @return the nroDocumento
	 */
	public String getNroDocumento() {
		return nroDocumento;
	}

	/**
	 * @param nroDocumento the nroDocumento to set
	 */
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
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

	public List<Detalle_Compra> getListaDetalleCompra() {
		return listaDetalleCompra;
	}

	public void setListaDetalleCompra(List<Detalle_Compra> listaDetalleCompra) {
		this.listaDetalleCompra = listaDetalleCompra;
	}
	
	
	
}
