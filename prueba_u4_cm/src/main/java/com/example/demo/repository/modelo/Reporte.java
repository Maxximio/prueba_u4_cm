package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

public class Reporte {

	private LocalDateTime fechaVenta;
	
	private String categoria;
	
	private Integer cantidad;

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Reporte(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		super();
		this.fechaVenta = fechaVenta;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}
	
}
