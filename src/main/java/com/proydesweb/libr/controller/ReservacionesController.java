package com.proydesweb.libr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proydesweb.libr.repository.*;
@Controller
public class ReservacionesController {
	
	
	@Autowired
	private IReservacionesRepository repo;
	
	@GetMapping("/reservaciones")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

		model.addAttribute("username", username);
		
		
		model.addAttribute("reservaciones", repo.findAll());
		
		return "Reservaciones/index";
		
	}
	

}
