package com.tienda.musical.app.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista extends Common{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artista_id")
	private Long idArtista;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "imagen", length = 100, nullable = false)
	private String imagen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nacionalidad_id")
	private Nacionalidad nacionalidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subgenero_id")
	private SubGenero subGenero;

	public Long getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Long idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public SubGenero getSubGenero() {
		return subGenero;
	}

	public void setSubGenero(SubGenero subGenero) {
		this.subGenero = subGenero;
	}
	
}
