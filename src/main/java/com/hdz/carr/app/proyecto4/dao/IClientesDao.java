package com.hdz.carr.app.proyecto4.dao;
import org.springframework.data.repository.CrudRepository;

import com.hdz.carr.app.proyecto4.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> {
		
	
}
