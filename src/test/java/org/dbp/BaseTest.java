package org.dbp;

import static org.junit.Assert.*;

import org.dbp.bom.Prueba;
import org.dbp.conf.ConfiguracionTest;
import org.dbp.conf.PersistenciaJPAConfig;
import org.dbp.dao.PruebaDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = {PersistenciaJPAConfig.class, ConfiguracionTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {
	@Autowired
	private PruebaDao dao;
	
	@Test
	public void pruebaBase(){
		Prueba entidad =new Prueba();
		entidad.setId(2L);
		dao.insertar(entidad);
		assertEquals(1,dao.obtenerTodas().size());
	}
	
}
