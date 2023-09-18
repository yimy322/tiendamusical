package com.tienda.musical.app.models.service;

import java.util.List;

import com.tienda.musical.app.models.entity.Album;

public interface IAlbumService {

	//CRUD
	public void save(Album album);
	
	public List<Album> findAll();
	
	public void delete(Long id);	
	
}
