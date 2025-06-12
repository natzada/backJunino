package com.lenoca.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenoca.demo.entities.Usuario;
import com.lenoca.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
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
	    return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
	}


}
