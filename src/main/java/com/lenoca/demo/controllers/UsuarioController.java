package com.lenoca.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lenoca.demo.entities.Usuario;
import com.lenoca.demo.repository.UsuarioRepository;
import com.lenoca.demo.services.UsuarioService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = usuarioService.getAll();

		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findUsuarioById(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);

		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		Usuario newUsuario = usuarioService.saveUsuario(usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuarioById(@PathVariable Long id) {
		usuarioService.deleteUsuarioById(id);
	}
	@GetMapping("/login")
	public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String senha) {
	    Usuario usuario = usuarioService.autenticar(email, senha);
	    if (usuario != null) {
	        return ResponseEntity.ok(usuario);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}



    
}
