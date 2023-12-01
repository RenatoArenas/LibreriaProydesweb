package com.proydesweb.libr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proydesweb.libr.model.Usuario;

@Controller
public class UsuarioController {

	
	@GetMapping("/login")
	public String login(@RequestParam(name = "error", required = false) Boolean error, Model model) {
		

		if (error != null && error) {
            model.addAttribute("mensajeError", "Credenciales incorrectas. Por favor, inténtelo nuevamente.");
        }
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
}
