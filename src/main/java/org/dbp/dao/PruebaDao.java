package org.dbp.dao;

import java.util.List;

import org.dbp.bom.Prueba;

public interface PruebaDao {

	public abstract void insertar(Prueba entidad);

	public abstract List<Prueba> obtenerTodas();

}
