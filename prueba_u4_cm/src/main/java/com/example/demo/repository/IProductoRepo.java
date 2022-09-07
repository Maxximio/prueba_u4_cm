package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepo {

	public Producto buscar(Integer id);
	
	public void actualizar(Producto prod);
	
	public void eliminar(Integer id);
	
	public void insertar(Producto prod);

	public Producto buscarCodigo(String cod);

	public Producto buscarCriteriaCodigo(String cod);
	
}
