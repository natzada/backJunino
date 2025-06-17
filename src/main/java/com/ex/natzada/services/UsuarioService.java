package com.ex.natzada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.natzada.entities.Usuario;
import com.ex.natzada.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
		
	}
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);
	}
	public Usuario autenticar(String email, String senha) {
	    return usuarioRepository.findByEmailAndPassword(email, senha).orElse(null);
	}


}
