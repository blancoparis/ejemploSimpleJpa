package org.dbp.bom;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prueba {
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
