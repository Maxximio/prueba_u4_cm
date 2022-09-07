package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.DetalleVenta;
import com.example.demo.repository.modelo.Producto;

public interface IGestorService {

	public void realizarVenta(List<Producto> productos, 
			String cedulaCliente, String numeroVenta);

	public  List<DetalleVenta> generarReporte(LocalDateTime fechaVenta, 
			String categoria, Integer cantidad);

}
