package com.tienda.musical.app.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nacionalidad")
public class Nacionalidad extends Common{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nacionalidad_id")
	private Long idNacionalidad;
	
	@Column(name = "descripcion", length = 60, nullable = false)
	private String descripcion;
	
	@Column(name = "abreviacion", length = 4, nullable = false)
	private String abreviacion;

	public Long getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(Long idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

}
