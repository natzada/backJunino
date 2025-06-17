package com.ex.natzada.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String nome;
	
	private String password;
	
	private String cpf;
	
	public Usuario() {
	}

	public Usuario(Long id, String email, String nome, String password, String cpf) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.password = password;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

<<<<<<< HEAD
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
=======
	public String getSenha() {
		return password;
	}

	public void setSenha(String password) {
>>>>>>> ada3173f40450b623d3fde75de46268eaccc93e7
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}