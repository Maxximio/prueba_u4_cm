package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDetalleVentaRepo;
import com.example.demo.repository.IProductoRepo;
import com.example.demo.repository.IVentaRepo;
import com.example.demo.repository.modelo.DetalleVenta;
import com.example.demo.repository.modelo.Venta;
import com.example.demo.repository.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private IProductoRepo productoRepo;

    @Autowired
    private IVentaRepo ventaRepo;

    @Autowired
    private IDetalleVentaRepo detalleVentaRepo;
    
    private static Logger log = Logger.getLogger(GestorServiceImpl.class);

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void realizarVenta(List<Producto> productos, String cedulaCliente, String numeroVenta) {
        
        Venta venta = new Venta();
        BigDecimal total = new BigDecimal("0");
        List<DetalleVenta> listaDetalles = new ArrayList<>();
        productos.forEach(producto -> {
            
            DetalleVenta detalleVenta = new DetalleVenta();
            
            try {
                Producto productoBuscado = this.productoRepo.buscarCodigo(producto.getCodigoBarras());
                BigDecimal precioUnitario = null;
                Integer cantidad = null;
                BigDecimal subtotal = null;
                if (productoBuscado.getCodigoBarras() != null) {
                    if (productoBuscado.getStock() <= 0) {
                        log.error("No existe stock");
                        throw new RuntimeException();
                    } else if (productoBuscado.getStock() <= producto.getStock()) {

                        cantidad = productoBuscado.getStock();

                    } else {
                        cantidad = producto.getStock();
                    }

                    precioUnitario = productoBuscado.getPrecio();
                    productoBuscado.setStock(productoBuscado.getStock() - cantidad);
                    detalleVenta.setCantidad(cantidad);
                    detalleVenta.setPrecioUnitario(precioUnitario);
                    subtotal = precioUnitario.multiply(new BigDecimal(cantidad));
                    detalleVenta.setSubtotal(subtotal);
                    detalleVenta.setProducto(productoBuscado);
                    detalleVenta.setVenta(venta);
                    listaDetalles.add(detalleVenta);
                    total.add(subtotal);
                    
                    this.productoRepo.actualizar(productoBuscado);

                    

                }
            } catch (Exception e) {
                log.error("El producto no existe");
                throw new RuntimeException();
            }
            
        });

        venta.setCedulaCliente(cedulaCliente);
        venta.setFecha(LocalDateTime.now());
        venta.setNumero(numeroVenta);
        venta.setTotalVenta(total);
        venta.setDetalles(listaDetalles);
        this.ventaRepo.insertar(venta);

    }

    @Override
    public  List<DetalleVenta> generarReporte(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
        List<DetalleVenta> lista = this.detalleVentaRepo.buscarReporte(fechaVenta, categoria, cantidad);
        lista.forEach(detalle -> log.info(detalle.toString()));
		return lista;
        
    }

}
