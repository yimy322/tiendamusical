package com.tienda.musical.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/agregar-canciones")
	public String canciones() {
		return "agregar-canciones";
	}
	
	@GetMapping("/agregar-artista")
	public String artistas() {
		return "agregar-artista";
	}
	
	@GetMapping("/agregar-album")
	public String albumes() {
		return "agregar-album";
	}
	
	@GetMapping("/agregar-extras")
	public String extras() {
		return "agregar-extras";
	}
	
}
