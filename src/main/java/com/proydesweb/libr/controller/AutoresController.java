package com.proydesweb.libr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proydesweb.libr.model.Autores;
import com.proydesweb.libr.repository.IAutoresRepository;

@Controller
public class AutoresController {
	
	@Autowired
	private IAutoresRepository auto;
	
	
	@GetMapping("/autores")
	public String index(Model model) {
		
		model.addAttribute("autor", new Autores());
		model.addAttribute("autores", auto.findAll());
		return "Autores/index";
		
	}
	
	@PostMapping("/autores/store")
	public String store(@ModelAttribute Autores autores) {
		auto.save(autores);
		return "redirect:/autores";
	}
	
	@PostMapping("/autores/update")
	public String update(@ModelAttribute Autores autores) {
		auto.save(autores);
		return "redirect:/autores";
	}
	
	@PostMapping("/autores/delete")
	public String delete(@ModelAttribute Autores autores) {
		auto.delete(autores);
		return "redirect:/autores";
	}

	
	
	
	
	
	

}
