package com.hdz.carr.app.proyecto4.dtos;

import java.util.Date;

public class PeriodoDTO {
	private Long id;
	private Date fechaDeInicio;
	private Date fechaDeFin;
	private Long proyecto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaDeInicio() {
		return fechaDeInicio;
	}
	public void setFechaDeInicio(Date fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}
	public Date getFechaDeFin() {
		return fechaDeFin;
	}
	public void setFechaDeFin(Date fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}
	public Long getProyecto() {
		return proyecto;
	}
	public void setProyecto(Long proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
