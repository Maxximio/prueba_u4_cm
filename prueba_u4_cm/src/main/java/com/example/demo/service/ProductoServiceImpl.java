package com.example.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepo;
import com.example.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	private static Logger log = Logger.getLogger(ProductoServiceImpl.class);

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProductos(Producto p) {
		try {
			Producto productoBuscado = this.productoRepo.buscarCodigo(p.getCodigoBarras());
			if (productoBuscado.getCodigoBarras() != null) {
				Integer nuevoStock = p.getStock() + productoBuscado.getStock();
				productoBuscado.setStock(nuevoStock);

				log.info("El producto se ha actualizado");
				this.productoRepo.actualizar(productoBuscado);
			}
		} catch (Exception e) {

			log.info("El producto se ha insertado");

			this.productoRepo.insertar(p);
		}
	}

	@Override
	public Producto consultarStock(String codigo) {
		Producto p = this.productoRepo.buscarCriteriaCodigo(codigo);

		log.info("Codigo de Barras: " + p.getCodigoBarras() + "\tNombre: " + p.getNombre() + "\tStock: " + p.getStock());
		return p;

	}

}
