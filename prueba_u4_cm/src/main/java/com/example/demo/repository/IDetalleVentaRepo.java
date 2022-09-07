package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaRepo {

	public DetalleVenta buscar(Integer id);
	
	public void actualizar(DetalleVenta deve);
	
	public void eliminar(Integer id);
	
	public void insertar(DetalleVenta deve);
	
	public List<DetalleVenta> buscarReporte(LocalDateTime fechaVenta, String categoria, Integer cantidad);
	
}
