package com.proydesweb.libr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proydesweb.libr.model.Categoria;
import com.proydesweb.libr.model.Editoriales;
import com.proydesweb.libr.repository.IEditorialesRepository;

@Controller
public class EditorialesController {
	
	@Autowired
	private IEditorialesRepository edit;
	
	@GetMapping("/editoriales")
	public String  index(Model model) {
		
		model.addAttribute("editorial", new Editoriales());
		model.addAttribute("editoriales", edit.findAll());
		
		return "Editoriales/index";
	}
	
	@PostMapping("/editoriales/store")
	public String store(@ModelAttribute Editoriales editorial) {
		edit.save(editorial);
		return "redirect:/editoriales";
	}
	
	@PostMapping("/editoriales/update")
	public String update(@ModelAttribute Editoriales editorial) {
		edit.save(editorial);
		return "redirect:/editoriales";
	}
	
	
	@PostMapping("/editoriales/delete")
	public String delete(@ModelAttribute Editoriales editorial) {
		edit.delete(editorial);
		return "redirect:/editoriales";
	}
	
	
	
	
	
	

}
