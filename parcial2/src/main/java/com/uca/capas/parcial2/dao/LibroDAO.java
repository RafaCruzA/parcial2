package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;



public interface LibroDAO {
	
public List<Libro> findAll() throws DataAccessException;
	
	public Libro findOne(Integer codigo) throws DataAccessException;
	
	public void save(Libro c) throws DataAccessException;

}
