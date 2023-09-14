package com.tienda.musical.app.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@Secured("ROLE_USER")
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
}
