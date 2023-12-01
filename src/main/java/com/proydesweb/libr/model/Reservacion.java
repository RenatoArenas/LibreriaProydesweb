 package com.proydesweb.libr.model;

import java.sql.Timestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
 @Table(name="tb_reservacion")
public class Reservacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Timestamp fecha;
	
	@ManyToOne
	@JoinColumn(name="idlibro")
	Libro libro;
	
	
	@ManyToOne
	@Nullable
	@JoinColumn(name="idcliente")
	Cliente cliente;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
