package com.hdz.carr.app.proyecto4.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdz.carr.app.proyecto4.dao.IClientesDao;
import com.hdz.carr.app.proyecto4.dao.IProyectoDao;
import com.hdz.carr.app.proyecto4.dtos.ProyectoDTO;
import com.hdz.carr.app.proyecto4.models.Proyecto;

@Service
public class ProyectoService implements IService<Proyecto, ProyectoDTO>{
	
	@Autowired
	private IProyectoDao proyectoDao;
	
	@Autowired
	private IClientesDao  clienteDao;
	
	@Override
	public List<Proyecto> listar() {
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos = (List<Proyecto>) proyectoDao.findAll();
		return proyectos;
	}

	@Override
	public Optional<Proyecto> getById(Long id) {
		Optional<Proyecto> proyecto = proyectoDao.findById(id);
		return proyecto;
	}

	@Override
	public void guardar(ProyectoDTO t) {
		this.proyectoDao.save(convirtirDTOaProyecto(t));
	}

	@Override
	public void eliminar(Long id) {
		this.proyectoDao.deleteById(id);
	}

	public Proyecto convirtirDTOaProyecto(ProyectoDTO periodoDto) {
		
		Proyecto p = new Proyecto();
		p.setId(periodoDto.getId());
		p.setDescripcion(periodoDto.getDescripcion());
		p.setCliente(clienteDao.findById(periodoDto.getCliente()).get());
		return p;
	}
}
