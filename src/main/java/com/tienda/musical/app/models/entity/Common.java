package com.tienda.musical.app.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
//Clase que contiene campos comunes
@MappedSuperclass//Para compartir atributos
public class Common {

	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	
	@Column(name = "estatus")
	private boolean estatus;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
}
