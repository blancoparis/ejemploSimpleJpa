package org.dbp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbp.bom.Prueba;
import org.dbp.dao.PruebaDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * 
 * Implementación de la prueba
 * 
 * @author David Blanco París
 *
 */
@Repository
public class PruebaDaoImpl  implements PruebaDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void insertar(Prueba entidad){
		entityManager.persist(entidad);
	}
	
}
