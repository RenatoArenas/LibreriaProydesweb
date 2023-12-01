package com.proydesweb.libr.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proydesweb.libr.model.Libro;
import com.proydesweb.libr.model.Reservacion;
import com.proydesweb.libr.repository.*;
@Controller
public class LibrosController {
	
	@Autowired
	private ILibrosRepository repo;
	
	@Autowired
	private IClientesRepository repocli;

	@Autowired
	private IAutoresRepository repoau;
	
	@Autowired
	private ICategoriaRepository repocat;	
	
	@Autowired
	private IEditorialesRepository repoedit;
	
	@Autowired
	private IReservacionesRepository repores;
	
	@GetMapping("/libros")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

		model.addAttribute("username", username);
		
		model.addAttribute("libro", new Libro());
		
		model.addAttribute("libros", repo.findAll());
		model.addAttribute("clientes", repocli.findByEstado(true));
		model.addAttribute("autores", repoau.findByEstado(true));
		model.addAttribute("categorias", repocat.findByEstado(true));
		model.addAttribute("editoriales", repoedit.findByEstado(true));
		
		return "Libros/index";
		
	}
	
	@PostMapping("/libros/store")
	public String store(@ModelAttribute Libro libros) {
		libros.setEstado(true);
		repo.save(libros);
		return "redirect:/libros";
	}
	
	@PostMapping("/libros/update")
	public String update(@ModelAttribute Libro libros) {
		repo.save(libros);
		return "redirect:/libros";
	}
	
	@PostMapping("/libros/delete")
	public String delete(@ModelAttribute Libro libros) {
		repo.delete(libros);
		return "redirect:/libros";
	}
	
	@PostMapping("/libros/reservar")
	public String reservar(@ModelAttribute Libro libros) {
		
		Libro libro = repo.findById(libros.getId()).get();
		
		libro.setCliente(libros.getCliente());
		
		Reservacion reservacion = new Reservacion();
		
		reservacion.setFecha(new Timestamp(System.currentTimeMillis()));
		reservacion.setLibro(libro);
		reservacion.setCliente(libro.getCliente());
		
		repo.save(libro);
		repores.save(reservacion);
		return "redirect:/libros";
	}
	
	@PostMapping("/libros/anular")
	public String anular(@ModelAttribute Libro libros) {
		
		Libro libro = repo.findById(libros.getId()).get();
		
		libro.setCliente(null);
		
		repo.save(libro);
		return "redirect:/libros";
	}

	
	
	
	
	
	

}
