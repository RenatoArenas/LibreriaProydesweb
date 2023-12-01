package com.proydesweb.libr.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proydesweb.libr.model.Reservacion;

public interface IReservacionesRepository extends JpaRepository<Reservacion, Integer> {

	
}
