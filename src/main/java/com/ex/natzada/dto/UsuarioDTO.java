package com.ex.natzada.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Email inválido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String senha;

    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @AssertTrue(message = "CPF inválido.")
    public boolean isCpfValido() {
        if (cpf == null) return false;

        String cpfLimpo = cpf.replaceAll("[^\\d]", "");

        if (cpfLimpo.length() != 11 || cpfLimpo.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpfLimpo.charAt(i));
                d1 += digito * (10 - i);
                d2 += digito * (11 - i);
            }

            int resto1 = d1 % 11;
            resto1 = (resto1 < 2) ? 0 : 11 - resto1;

            d2 += resto1 * 2;
            int resto2 = d2 % 11;
            resto2 = (resto2 < 2) ? 0 : 11 - resto2;

            return resto1 == Character.getNumericValue(cpfLimpo.charAt(9)) &&
                   resto2 == Character.getNumericValue(cpfLimpo.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
