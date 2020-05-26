package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import com.uca.capas.parcial2.dao.CategoriaDAO;
import com.uca.capas.parcial2.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaDAO categoriaDao;
	
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	public Categoria findOne(Integer codigo) throws DataAccessException {
		return categoriaDao.findOne(codigo);
	}
	
	@Override
	public void insert(Categoria categoria) throws DataAccessException {
		categoriaDao.insert(categoria);
	}
	

}
