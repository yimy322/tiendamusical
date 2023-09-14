package com.tienda.musical.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musical.app.models.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	public Persona findByUsuario(String usuario);
	
}
