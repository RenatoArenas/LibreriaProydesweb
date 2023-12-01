 package com.proydesweb.libr.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
 @Table(name="tb_libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="ideditorial")
	Editoriales editorial;
	
	@ManyToOne
	@JoinColumn(name="idautor")
	Autores autor;
	
	@ManyToOne
	@Nullable
	@JoinColumn(name="idcliente")
	Cliente cliente;
	
	@Column(name="descripcion")
	private String descripcion;
	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Editoriales getEditorial() {
		return editorial;
	}

	public void setEditorial(Editoriales editorial) {
		this.editorial = editorial;
	}

	public Autores getAutor() {
		return autor;
	}

	public void setAutor(Autores autor) {
		this.autor = autor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
