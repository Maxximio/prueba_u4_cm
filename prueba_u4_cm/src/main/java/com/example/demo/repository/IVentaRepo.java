package com.example.demo.repository;

import com.example.demo.repository.modelo.Venta;

public interface IVentaRepo {

	public Venta buscar(Integer id);
	
	public void actualizar(Venta vent);
	
	public void eliminar(Integer id);
	
	public void insertar(Venta vent);
	
}
