package com.proydesweb.libr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_editoriales")
public class Editoriales {
	
	@Id
	
	private int id;

	@NotNull(message="El nombre de editoriales  es requerido")
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
