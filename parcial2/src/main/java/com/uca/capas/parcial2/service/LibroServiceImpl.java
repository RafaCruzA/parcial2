package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;


import com.uca.capas.parcial2.dao.LibroDAO;
import com.uca.capas.parcial2.domain.Libro;

public class LibroServiceImpl {
	
	@Autowired
	LibroDAO libroDao;
	
	public List<Libro> findAll() throws DataAccessException {
		return libroDao.findAll();
	}

	public Libro findOne(Integer codigo) throws DataAccessException {
		return libroDao.findOne(codigo);
	}

	@Transactional
	public void save(Libro c) throws DataAccessException {
		libroDao.save(c);
	}


}
