package com.tienda.musical.app.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disquera")
public class Disquera extends Common{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disquera_id")
	private Long idDisquera;
	
	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

	public Long getIdDisquera() {
		return idDisquera;
	}

	public void setIdDisquera(Long idDisquera) {
		this.idDisquera = idDisquera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
