package com.proydesweb.libr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Editoriales;

public interface IEditorialesRepository  extends JpaRepository<Editoriales,Integer>{
	List<Editoriales> findByEstado(boolean estado);
}
