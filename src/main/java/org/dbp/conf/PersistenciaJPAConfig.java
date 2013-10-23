package org.dbp.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration		
@EnableTransactionManagement
public class PersistenciaJPAConfig {
	/**
	 * Configuramos un dataSource, para que conecte a una hsqldb en memoria.
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	/**
	 * Configuramos el entity manager en JPA.
	 * 		- Le indicamos el data source con el que va a trabajar.
	 * 		- Le indicamos el paquete donde se encuentran las clases.
	 * 		- Le pasamos el adaptador de JPA que en nuestro caso sera hibernate.
	 * 		- Por otro lado le pasamos las propiedades.
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactoryBean(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[]{"ejemplo.bom"});
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(propiedadesAdicionalesJpa());
		return em;
	}
	/**
	 * Le indicamos el tipo de configuración que nos interesa para hibernate
	 * 	- Le indicmaos que cada vez que entremos borre y cree las B.D.
	 *  - Le indicamos que utilice el dialecto con HSQL.
	 *  
	 *  Nota: este método no es parte de la configuración de spring.
	 * @return
	 */
	private Properties propiedadesAdicionalesJpa(){
		return new Properties(){
			{
				setProperty("hibernate.hbm2ddl.auto", "create-drop");
				setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
			}
		};
	}
	
	/**
	 * Configura las transaciones en JPA. 
	 * @return
	 */
    @Bean
 	public PlatformTransactionManager transactionManager(){
	     JpaTransactionManager transactionManager = new JpaTransactionManager();
	     transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject() );
	     return transactionManager;
	}
	
}
