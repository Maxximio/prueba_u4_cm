package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.DetalleVenta;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.RealizaVentasTo;
import com.example.demo.repository.modelo.Reporte;
import com.example.demo.service.IGestorService;

@Controller
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private IGestorService gestorService;
	
	@PostMapping("/insertar")
	public String insertarProducto(RealizaVentasTo venta) {
		
		List<Producto> lista=new ArrayList<>();
		Producto p=new Producto();
		p.setCodigoBarras(venta.getCodBarrasProd());
		p.setStock(venta.getCantidad());
		
		lista.add(p);
		
		this.gestorService.realizarVenta(lista, venta.getCedulaCliente(), venta.getNumeroVenta());
		return "exito";
	}

	@GetMapping("/nuevaVenta")
	public String paginaNuevaVenta(RealizaVentasTo venta,Model modelo) {
		
		
		modelo.addAttribute("venta",venta);
		return "vistaNuevaVenta";
	}
	
	@GetMapping("/nuevoReporte")
	public String paginaNuevoReporte(Reporte repo,Model modelo) {
		
		modelo.addAttribute("reporte",repo);
		return "vistaNuevoReporte";
	}
	
	@GetMapping("/cargadoLista")//get
	public String buscarTodos(Model modelo,Reporte repo){
		List<DetalleVenta> listaD=this.gestorService.generarReporte(repo.getFechaVenta()
				, repo.getCategoria(), repo.getCantidad());
		modelo.addAttribute("lista",listaD);
		return "vistaListaCitas";
	}
	
}
