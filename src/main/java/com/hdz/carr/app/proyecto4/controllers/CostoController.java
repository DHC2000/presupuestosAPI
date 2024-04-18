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

import com.hdz.carr.app.proyecto4.dtos.CostoDTO;
import com.hdz.carr.app.proyecto4.models.Costo;
import com.hdz.carr.app.proyecto4.services.IService;

@RestController
@RequestMapping("/proyecto4/costo")
@CrossOrigin(origins = "*")
public class CostoController {
	
	@Autowired
	IService<Costo,CostoDTO> costoServices;
	
	@PostMapping
	public Map<String,String> guardar(@RequestBody CostoDTO c){
		costoServices.guardar(c);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Costo guardado!");
		return respuesta;
	}
	
	@GetMapping
	public List<Costo> listar(){
		return costoServices.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Costo obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Costo> costo = costoServices.getById(id);
		if (costo.isPresent()) {
			return costo.get();		
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id") Long id){
		costoServices.eliminar(id);
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Costo eliminado!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody CostoDTO c, @PathVariable(name = "id") Long id){
		Optional<Costo> proyecto = costoServices.getById(id);
		if (proyecto.isPresent()) {
			c.setId(id);
			costoServices.guardar(c);
		}else {
			throw new RuntimeException("El costo no existe en la BD");
		}
		Map<String,String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Costo actualizado!");
		return respuesta;
	}

}
