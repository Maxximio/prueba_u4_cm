package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		this.productoService.ingresarProductos(producto);
		return "exito";
	}
	
	@GetMapping("/nuevoProducto")
	public String paginaNuevoProducto(Producto producto,Model modelo) {
		modelo.addAttribute("producto",producto);
		return "vistaNuevoProducto";
	}
	
	@GetMapping("/consultar")
	public String paginaConsultaProducto(Producto producto,Model modelo) {
		modelo.addAttribute("producto",producto);
		return "vistaBuscarProducto";
	}
	
	@GetMapping("/mostrarProd")
	public String buscarTodos(Producto producto,Model modelo){
		Producto p=this.productoService.consultarStock(producto.getCodigoBarras());
		modelo.addAttribute("producto",p);
		return "vistaProductoStock";
	}
	
}
