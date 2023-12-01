package com.proydesweb.libr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Libro;

public interface ILibrosRepository extends JpaRepository<Libro, Integer> {

	List<Libro> findByEstado(boolean estado);
	
}
