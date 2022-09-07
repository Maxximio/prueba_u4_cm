package com.example.demo.service;

import com.example.demo.repository.modelo.Producto;

public interface IProductoService {

	 public void ingresarProductos(Producto p);

	 public Producto consultarStock(String codigo);
	
}
