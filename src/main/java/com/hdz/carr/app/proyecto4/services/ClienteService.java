package com.hdz.carr.app.proyecto4.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdz.carr.app.proyecto4.dao.IClientesDao;
import com.hdz.carr.app.proyecto4.models.Cliente;

@Service
public class ClienteService implements IService<Cliente,Cliente>{
	
	@Autowired
	private IClientesDao clienteDao;

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (List<Cliente>) clienteDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		Optional<Cliente> cliente = clienteDao.findById(id);
		return cliente;
	}

	@Override
	public void guardar(Cliente t) {
		this.clienteDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		this.clienteDao.deleteById(id);
	}

}
