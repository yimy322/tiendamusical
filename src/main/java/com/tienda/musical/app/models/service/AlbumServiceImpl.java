package com.tienda.musical.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.musical.app.models.dao.IAlbumDao;
import com.tienda.musical.app.models.entity.Album;

@Service
public class AlbumServiceImpl implements IAlbumService{
	
	@Autowired
	private IAlbumDao albumDao;

	@Override
	public void save(Album album) {
		albumDao.save(album);
		
	}

	@Override
	public List<Album> findAll() {
		return (List<Album>) albumDao.findAll();
	}

	@Override
	public void delete(Long id) {
		albumDao.deleteById(id);
		
	}

}
