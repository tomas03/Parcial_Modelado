package com.cooweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cooweb.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
 public class UsuarioDaoImpl implements UsuarioDao{
    
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override   
	@Transactional
	public List<Usuario> getUsuarios() {	
		
		String query="FROM Usuario";
		List<Usuario> resultado=entityManager.createQuery(query).getResultList();
		
		return resultado;
		
		
	}
	
	@Override
	public void eliminar(Long id) {	
		Usuario usuario=entityManager.find(Usuario.class,id);
		entityManager.remove(usuario);
		
	}
}

