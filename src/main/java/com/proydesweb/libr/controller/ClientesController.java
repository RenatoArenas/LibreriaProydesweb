package com.proydesweb.libr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proydesweb.libr.model.Cliente;
import com.proydesweb.libr.repository.IClientesRepository;

@Controller
public class ClientesController {
	
	@Autowired
	private IClientesRepository auto;
	
	
	@GetMapping("/clientes")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

		model.addAttribute("username", username);
		
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("clientes", auto.findAll());
		return "Clientes/index";
		
	}
	
	@PostMapping("/clientes/store")
	public String store(@ModelAttribute Cliente clientes) {
		clientes.setEstado(true);
		auto.save(clientes);
		return "redirect:/clientes";
	}
	
	@PostMapping("/clientes/update")
	public String update(@ModelAttribute Cliente clientes) {
		auto.save(clientes);
		return "redirect:/clientes";
	}
	
	@PostMapping("/clientes/delete")
	public String delete(@ModelAttribute Cliente clientes) {
		auto.delete(clientes);
		return "redirect:/clientes";
	}

	
	
	
	
	
	

}
