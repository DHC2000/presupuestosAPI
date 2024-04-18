package com.hdz.carr.app.proyecto4.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpaP4_clientes")
@Entity
public class Cliente {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ1")
	@SequenceGenerator(sequenceName =  "customer_seq1",allocationSize = 1, name = "CUST_SEQ1")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	//2
	@Column(name = "ap_materno")
	private String apMaterno;
	
	//2
	@Column(name = "telefono")
	private String telefono;

	//2
	@Column(name = "correo")
	private String correo;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
}
