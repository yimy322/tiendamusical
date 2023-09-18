package com.tienda.musical.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tienda.musical.app.models.entity.Album;
import com.tienda.musical.app.models.service.IAlbumService;

@Controller
public class InicioController {

	@Autowired
	private IAlbumService albumService;
	
	@Secured("ROLE_USER")
	@GetMapping("/")
	public String inicio(Model model) {
		
		List<Album> albumes = albumService.findAll();
		
		model.addAttribute("albumes", albumes);
		
		return "inicio";
	}
	
}
