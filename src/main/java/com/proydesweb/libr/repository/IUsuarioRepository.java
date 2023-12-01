package com.proydesweb.libr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsuario(String usuario);
}
