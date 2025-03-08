package com.cooweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cooweb.dao.UsuarioDao;
import com.cooweb.models.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("api/usuarios")
	public	List<Usuario> getUsuarios() {	
    		List<Usuario> user=usuarioDao.getUsuarios();
    	return user;
    }
    
	
	@PostMapping("api/usuarios")
	public void registrarUsuario(@RequestBody Usuario usuario) {
	    usuarioDao.registrar(usuario);
	}

   
    @DeleteMapping("api/usuarios/{id}")
	public void eliminar(@PathVariable Long id){
		usuarioDao.eliminar(id);
	}
    
}
