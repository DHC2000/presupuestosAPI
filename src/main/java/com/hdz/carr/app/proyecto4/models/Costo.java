package com.hdz.carr.app.proyecto4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpaP4_costos")
@Entity
public class Costo {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName =  "customer_seq3",allocationSize = 1, name = "CUST_SEQ3")
	private Long id;
	
	//2
	@Column(name = "materia_bruta")
	private Double materiaBruta;
	
	//2
	@Column(name = "mantenimiento_equipo")
	private Double mantenimientoDeEquipo;
	
	//2
	@Column(name = "servicios_requeridos")
	private Double serviciosRequeridos;
	
	//2
	@Column(name = "precio_desarrolo")
	private Double precioDeDesarrollo;
	
	//2
	@JoinColumn(name = "proyecto_id")
	@OneToOne
	private Proyecto proyecto;

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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
