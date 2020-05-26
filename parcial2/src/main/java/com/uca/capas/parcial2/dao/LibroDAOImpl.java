package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;



public class LibroDAOImpl implements LibroDAO{
	@PersistenceContext(unitName = "parcial2")
	EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> res = query.getResultList();
		return res;
	}

	public Libro findOne(Integer codigo) throws DataAccessException {
	
		Libro c = entityManager.find(Libro.class, codigo);
		return c;
	}

	public void save(Libro c) throws DataAccessException {
		
		if(c.getClibro() == null) { 
			entityManager.persist(c);
		}
		else { 
			entityManager.merge(c); 
		}
		

}
}
