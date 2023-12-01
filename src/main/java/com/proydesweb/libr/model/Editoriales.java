package com.proydesweb.libr.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_editoriales")
public class Editoriales {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private boolean estado;
	
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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}
