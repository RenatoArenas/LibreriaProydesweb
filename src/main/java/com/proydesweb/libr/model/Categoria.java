package com.proydesweb.libr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_categorias")
public class Categoria {
	
	@Id
	private int id;
	
	@NotNull(message="El nombre de la categoría es requerido")
	@Column(name="nombre", unique=true)
	private String nombre;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
