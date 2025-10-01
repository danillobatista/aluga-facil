package com.example.alugafacil.alugafacil.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class InquilinoDto {

    private Integer id;

    @NotNull(message = "o campo NOME é obrigatório")
    @Length(min = 10, max = 200, message = "o campo NOME deve ter entre 10 e 200 caracteres")
    private String nome;

    private String email;

    public InquilinoDto() {
    }

    public InquilinoDto(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
