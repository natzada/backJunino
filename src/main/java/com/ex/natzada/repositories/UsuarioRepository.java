package com.ex.natzada.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ex.natzada.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")
	Optional<Usuario> login(@Param("email") String email, @Param("password") String password);

	Optional<Usuario> findByEmailAndPassword(String email, String password);


}
