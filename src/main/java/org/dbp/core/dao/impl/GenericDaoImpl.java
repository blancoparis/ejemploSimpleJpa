package org.dbp.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dbp.core.dao.GenericDao;
import org.springframework.transaction.annotation.Transactional;

public class GenericDaoImpl <T extends Serializable,ID extends Serializable> implements GenericDao<T,ID>{

	private Class<T> clazzT;
	private Class<ID> clazzID;
	
	@PersistenceContext
	private EntityManager em;
	
	
	

	public GenericDaoImpl(Class<T> clazzT, Class<ID> clazzID) {
		super();
		this.clazzT = clazzT;
		this.clazzID = clazzID;
	}
	
	/**
	 * 
	 */
	@Transactional
	public void insertar(T entidad) {
		em.persist(entidad);
	}
	
	@Transactional
	public List<T> obtenerTodos() {
		Query query=em.createQuery(" select e from "+clazzT.getSimpleName()+" e", clazzT);
		return (List<T>)query.getResultList();
	}


	
	// Datos acesibles por el hijo.
	
	public Class<T> getClazzT() {
		return clazzT;
	}

	public Class<ID> getClazzID() {
		return clazzID;
	}

	public EntityManager getEm() {
		return em;
	}

}
