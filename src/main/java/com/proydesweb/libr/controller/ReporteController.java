package com.proydesweb.libr.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.io.IOException;
import java.io.OutputStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proydesweb.libr.repository.IAutoresRepository;
import com.proydesweb.libr.repository.ICategoriaRepository;
import com.proydesweb.libr.repository.IClientesRepository;
import com.proydesweb.libr.repository.IEditorialesRepository;
import com.proydesweb.libr.repository.ILibrosRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReporteController {
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
	private ResourceLoader resourceLoader;
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/reportes")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

		model.addAttribute("username", username);
		
		
		model.addAttribute("libros", repo.findAll());
		model.addAttribute("clientes", repocli.findByEstado(true));
		model.addAttribute("autores", repoau.findByEstado(true));
		model.addAttribute("categorias", repocat.findByEstado(true));
		model.addAttribute("editoriales", repoedit.findByEstado(true));
		
		return "Reportes/index";
		
	}
	
	@PostMapping(value="/reportes", params="exportar_libaut")
	public void exportarlibaut(@RequestParam(name="idautor") int idautor, HttpServletResponse response) throws JRException, SQLException {
		
		String nombreReporte = "ReporteLibrosPorAutor";
		response.setHeader("Content-Disposition", "attachment; filename="+nombreReporte+".pdf");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ReporteLibro.jasper").getURI().getPath();
			HashMap<String, Object>parametros = new HashMap<>();
			parametros.put("idautor", idautor);
			parametros.put("idcategoria", 0);
			parametros.put("ideditorial", 0);
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection()); 
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/reportes", params="exportar_libcat")
	public void exportarlibcat(@RequestParam(name="idcategoria") int idcategoria, HttpServletResponse response) throws JRException, SQLException {
		
		String nombreReporte = "ReporteLibrosPorCategoría";
		response.setHeader("Content-Disposition", "attachment; filename="+nombreReporte+".pdf");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ReporteLibro.jasper").getURI().getPath();
			HashMap<String, Object>parametros = new HashMap<>();
			parametros.put("idcategoria", idcategoria);
			parametros.put("idautor", 0);
			parametros.put("ideditorial", 0);
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection()); 
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/reportes", params="exportar_libed")
	public void exportarlibed(@RequestParam(name="ideditorial") int ideditorial, HttpServletResponse response) throws JRException, SQLException {
		
		String nombreReporte = "ReporteLibrosPorEditorial";
		response.setHeader("Content-Disposition", "attachment; filename="+nombreReporte+".pdf");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ReporteLibro.jasper").getURI().getPath();
			HashMap<String, Object>parametros = new HashMap<>();
			parametros.put("ideditorial", ideditorial);
			parametros.put("idcategoria", 0);
			parametros.put("idautor", 0);
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection()); 
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/reportes", params="exportar_greslib")
	public void exportargreslib(HttpServletResponse response) throws JRException, SQLException {
		
		String nombreReporte = "GraficoReservacionesPorLibro";
		response.setHeader("Content-Disposition", "attachment; filename="+nombreReporte+".pdf");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ReporteReservacionesPorLibro.jasper").getURI().getPath();
			HashMap<String, Object>parametros = new HashMap<>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection()); 
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/reportes", params="exportar_grescli")
	public void exportargrescli(HttpServletResponse response) throws JRException, SQLException {
		
		String nombreReporte = "GraficoReservacionesPorCliente";
		response.setHeader("Content-Disposition", "attachment; filename="+nombreReporte+".pdf");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/ReporteReservacionesPorCliente.jasper").getURI().getPath();
			HashMap<String, Object>parametros = new HashMap<>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection()); 
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
