package com.tienda.musical.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

	@GetMapping("/registro")
	public String registro() {
		return "registro";
	}
	
}
