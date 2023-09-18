package com.tienda.musical.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musical.app.models.entity.Album;

public interface IAlbumDao extends JpaRepository<Album, Long> {

}
