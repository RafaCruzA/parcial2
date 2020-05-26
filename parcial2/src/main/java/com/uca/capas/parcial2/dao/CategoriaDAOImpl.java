package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Categoria;


@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	@PersistenceContext(unitName = "parcial2")
	EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> res = query.getResultList();
		return res;
	}

	public Categoria findOne(Integer codigo) throws DataAccessException {
	
		Categoria c = entityManager.find(Categoria.class, codigo);
		return c;
	}

	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		entityManager.persist(categoria);
	}
		

}
