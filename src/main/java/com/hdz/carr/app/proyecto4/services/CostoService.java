package com.hdz.carr.app.proyecto4.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdz.carr.app.proyecto4.dao.ICostoDao;
import com.hdz.carr.app.proyecto4.dao.IProyectoDao;
import com.hdz.carr.app.proyecto4.dtos.CostoDTO;
import com.hdz.carr.app.proyecto4.models.Costo;

@Service
public class CostoService implements IService<Costo, CostoDTO>{
	
	@Autowired
	private ICostoDao costoDao;
	
	@Autowired
	private IProyectoDao proyectoDao;
	
	@Override
	public List<Costo> listar() {
		List<Costo> costos = new ArrayList<Costo>();
		costos = (List<Costo>) costoDao.findAll();
		return costos;
	}

	@Override
	public Optional<Costo> getById(Long id) {
		Optional<Costo> costo = costoDao.findById(id);
		return costo;
	}

	@Override
	public void guardar(CostoDTO t) {
		this.costoDao.save(convertirDTOaCosto(t));
	}

	@Override
	public void eliminar(Long id) {
		this.costoDao.deleteById(id);
	}
	
	public Costo convertirDTOaCosto(CostoDTO costoDto) {
		Costo c = new Costo();
		c.setId(costoDto.getId());
		c.setMateriaBruta(costoDto.getMateriaBruta());
		c.setMantenimientoDeEquipo(costoDto.getMantenimientoDeEquipo());
		c.setServiciosRequeridos(costoDto.getServiciosRequeridos());
		c.setPrecioDeDesarrollo(costoDto.getPrecioDeDesarrollo());
		c.setProyecto(proyectoDao.findById(costoDto.getProyecto()).get());
		return c;
	}

}
