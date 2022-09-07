package com.example.demo.repository.modelo;

public class RealizaVentasTo {
	
	private String cedulaCliente;
	
	private String numeroVenta;
	
	private String codBarrasProd;
	
	private Integer cantidad;

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public String getCodBarrasProd() {
		return codBarrasProd;
	}

	public void setCodBarrasProd(String codBarrasProd) {
		this.codBarrasProd = codBarrasProd;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
	public RealizaVentasTo(String cedulaCliente, String numeroVenta, String codBarrasProd, Integer cantidad) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.numeroVenta = numeroVenta;
		this.codBarrasProd = codBarrasProd;
		this.cantidad = cantidad;
	}

	public RealizaVentasTo() {
	}
	
}
