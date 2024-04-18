package com.hdz.carr.app.proyecto4.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdz.carr.app.proyecto4.dao.IPeriodoDao;
import com.hdz.carr.app.proyecto4.dao.IProyectoDao;
import com.hdz.carr.app.proyecto4.dtos.PeriodoDTO;
import com.hdz.carr.app.proyecto4.models.Periodo;

@Service
public class PeriodoService implements IService<Periodo, PeriodoDTO>{
	
	@Autowired
	private IPeriodoDao periodoDao;

	@Autowired
	private IProyectoDao proyectoDao;

	
	@Override
	public List<Periodo> listar() {
		List<Periodo> periodos = new ArrayList<Periodo>();
		periodos = (List<Periodo>) periodoDao.findAll();
		return periodos;
	}

	@Override
	public Optional<Periodo> getById(Long id) {
		Optional<Periodo> periodo = periodoDao.findById(id);
		return periodo;
	}

	@Override
	public void guardar(PeriodoDTO t) {
		this.periodoDao.save(convertirDTOaPeriodo(t));
	}

	@Override
	public void eliminar(Long id) {
		this.periodoDao.deleteById(id);
	}
	
	public Periodo convertirDTOaPeriodo(PeriodoDTO periodoDto) {
		
		Periodo p = new Periodo();
		p.setId(periodoDto.getId());
		p.setFechaDeInicio(periodoDto.getFechaDeInicio());
		p.setFechaDeFin(periodoDto.getFechaDeFin());
		p.setProyecto(proyectoDao.findById(periodoDto.getProyecto()).get());
		return p;
	}


}
