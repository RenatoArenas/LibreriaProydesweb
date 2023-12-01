package com.proydesweb.libr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Autores;

public interface IAutoresRepository   extends JpaRepository<Autores,Integer>{

	List<Autores> findByEstado(boolean estado);
	
}
