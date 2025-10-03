package com.example.alugafacil.alugafacil.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Schema(description = "DTO para operações de inquilino")
public class InquilinoDto {

    @Schema(description = "ID do inquilino", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Nome completo do inquilino", required = true, 
             example = "João da Silva")
    @NotNull(message = "o campo NOME é obrigatório")
    @Length(min = 10, max = 200, message = "o campo NOME deve ter entre 10 e 200 caracteres")
    private String nome;

    @Schema(description = "E-mail de contato do inquilino", 
            example = "joao.silva@example.com")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    public InquilinoDto() {
    }

    public InquilinoDto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
