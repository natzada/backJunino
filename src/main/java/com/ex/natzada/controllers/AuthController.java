package com.ex.natzada.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.natzada.dto.LoginRequest;
import com.ex.natzada.entities.Usuario;
import com.ex.natzada.repositories.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> userOpt = usuarioRepository.login(
                loginRequest.getEmail(), loginRequest.getPassword());

        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get()); // Sends full user (ID, name, email)
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciais inválidas");
    }
}

