package com.hdz.carr.app.proyecto4.dtos;

public class CostoDTO {
	private Long id;
	private Double materiaBruta;
	private Double mantenimientoDeEquipo;
	private Double serviciosRequeridos;
	private Double precioDeDesarrollo;
	private Long proyecto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMateriaBruta() {
		return materiaBruta;
	}
	public void setMateriaBruta(Double materiaBruta) {
		this.materiaBruta = materiaBruta;
	}
	public Double getMantenimientoDeEquipo() {
		return mantenimientoDeEquipo;
	}
	public void setMantenimientoDeEquipo(Double mantenimientoDeEquipo) {
		this.mantenimientoDeEquipo = mantenimientoDeEquipo;
	}
	public Double getServiciosRequeridos() {
		return serviciosRequeridos;
	}
	public void setServiciosRequeridos(Double serviciosRequeridos) {
		this.serviciosRequeridos = serviciosRequeridos;
	}
	public Double getPrecioDeDesarrollo() {
		return precioDeDesarrollo;
	}
	public void setPrecioDeDesarrollo(Double precioDeDesarrollo) {
		this.precioDeDesarrollo = precioDeDesarrollo;
	}
	public Long getProyecto() {
		return proyecto;
	}
	public void setProyecto(Long proyecto) {
		this.proyecto = proyecto;
	}
	

}
