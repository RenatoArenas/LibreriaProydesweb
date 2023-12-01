package com.proydesweb.libr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Cliente;

public interface IClientesRepository   extends JpaRepository<Cliente,Integer>{

	List<Cliente> findByEstado(boolean estado);
	
}
