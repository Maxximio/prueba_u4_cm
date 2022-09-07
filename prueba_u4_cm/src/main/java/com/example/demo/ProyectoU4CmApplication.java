package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.IProductoRepo;
import com.example.demo.service.IGestorService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class ProyectoU4CmApplication implements CommandLineRunner{

	@Autowired
	private IGestorService gestorService;
	
	@Autowired
	private IProductoService productoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU4CmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
	}

}
