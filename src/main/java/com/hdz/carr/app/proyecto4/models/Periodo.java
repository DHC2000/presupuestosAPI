package com.hdz.carr.app.proyecto4.models;

import java.util.Date;

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
@Table(name = "jpaP4_periodos")
@Entity
public class Periodo {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ4")
	@SequenceGenerator(sequenceName =  "customer_seq4",allocationSize = 1, name = "CUST_SEQ4")
	private Long id;
	
	//2
	@Column(name = "fecha_inicio")
	private Date fechaDeInicio;
	
	//2
	@Column(name = "fecha_fin")
	private Date fechaDeFin;
	
	@JoinColumn(name = "proyecto_id")
	@OneToOne
	private Proyecto proyecto;

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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
