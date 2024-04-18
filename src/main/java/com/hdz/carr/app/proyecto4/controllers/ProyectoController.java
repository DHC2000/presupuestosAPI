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

import com.hdz.carr.app.proyecto4.dtos.ProyectoDTO;
import com.hdz.carr.app.proyecto4.models.Proyecto;
import com.hdz.carr.app.proyecto4.services.IService;

@RestController
@RequestMapping("/proyecto4/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {

	@Autowired
	IService<Proyecto,ProyectoDTO> proyectoServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody ProyectoDTO c){
		proyectoServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Proyectoe guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Proyecto> listar(){
		return proyectoServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Proyecto obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Proyecto> proyecto = proyectoServices.getById(id);
		if (proyecto.isPresent()) {
			return proyecto.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		proyectoServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Proyecto eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody ProyectoDTO c, @PathVariable(name = "id") Long id){
		Optional<Proyecto> proyecto = proyectoServices.getById(id);
		if (proyecto.isPresent()) {
			c.setId(id);
			proyectoServices.guardar(c);
		}else {
			throw new RuntimeException("El proyecto no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Proyecto actualizado!");
		return respuesta;
	}

}
