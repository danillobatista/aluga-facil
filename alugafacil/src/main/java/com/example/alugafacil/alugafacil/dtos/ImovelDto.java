package com.example.alugafacil.alugafacil.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ImovelDto {

    private Integer id;

    @NotNull(message = "o campo DESCRIÇÃO é obrigatório")
    @Length(min = 10, max = 200, message = "o campo DESCRIÇÃO deve ter entre 10 e 200 caracteres")
    private String descricao;

    private String endereco;

    public ImovelDto() {
    }

    public ImovelDto(Integer id, String descricao, String endereco) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
