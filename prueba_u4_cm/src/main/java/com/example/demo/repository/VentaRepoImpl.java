package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	

	@PersistenceContext
	private EntityManager e;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Venta buscar(Integer id) {
		return this.e.find(Venta.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Venta vent) {
		this.e.merge(vent);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Venta gBorrar = this.buscar(id);
		this.e.remove(gBorrar);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Venta vent) {
		this.e.persist(vent);

	}

}
