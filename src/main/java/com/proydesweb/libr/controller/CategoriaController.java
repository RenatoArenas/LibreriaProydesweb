package com.proydesweb.libr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proydesweb.libr.model.Categoria;
import com.proydesweb.libr.repository.ICategoriaRepository;

@Controller
public class CategoriaController {
	
	@Autowired
	private ICategoriaRepository repo;
	
	@GetMapping("/categorias")
	public String  index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

		model.addAttribute("username", username);
		
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("categorias", repo.findAll());
		
		return "Categorias/index";
	}
	
	@PostMapping("/categorias/store")
	public String store(@ModelAttribute Categoria categoria) {
		categoria.setEstado(true);
		repo.save(categoria);
		return "redirect:/categorias";
	}
	
	@PostMapping("/categorias/update")
	public String update(@ModelAttribute Categoria categoria) {
		repo.save(categoria);
		return "redirect:/categorias";
	}
	
	@PostMapping("/categorias/delete")
	public String delete(@ModelAttribute Categoria categoria) {
		repo.delete(categoria);
		return "redirect:/categorias";
	}
	
}
