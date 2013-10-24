package org.dbp.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T extends Serializable,ID extends Serializable>{
	/**
	 * 
	 * Se encarga de insertar el interfaz
	 * 
	 * @param entidad
	 */
	public void insertar(T entidad);
	public List<T> obtenerTodos();
	
}
