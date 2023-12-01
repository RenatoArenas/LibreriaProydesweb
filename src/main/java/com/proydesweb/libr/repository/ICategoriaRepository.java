package com.proydesweb.libr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	List<Categoria> findByEstado(boolean estado);
}
