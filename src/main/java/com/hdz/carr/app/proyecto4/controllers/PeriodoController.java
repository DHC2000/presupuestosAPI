package com.hdz.carr.app.proyecto4.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdz.carr.app.proyecto4.dtos.PeriodoDTO;
import com.hdz.carr.app.proyecto4.models.Periodo;
import com.hdz.carr.app.proyecto4.services.IService;

@RestController
@RequestMapping("/proyecto4/periodo")
@CrossOrigin(origins = "*")
public class PeriodoController {
	
	@Autowired
	IService<Periodo,PeriodoDTO> periodoServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody PeriodoDTO c){
		periodoServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Periodo guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Periodo> listar(){
		return periodoServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Periodo obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Periodo> periodo = periodoServices.getById(id);
		if (periodo.isPresent()) {
			return periodo.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		periodoServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Periodo eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody PeriodoDTO c, @PathVariable(name = "id") Long id){
		Optional<Periodo> periodo = periodoServices.getById(id);
		if (periodo.isPresent()) {
			c.setId(id);
			periodoServices.guardar(c);
		}else {
			throw new RuntimeException("El periodo no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Periodo actualizado!");
		return respuesta;
	}

}
