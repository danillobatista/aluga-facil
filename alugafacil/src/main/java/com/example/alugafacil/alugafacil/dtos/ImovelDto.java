package com.example.alugafacil.alugafacil.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Schema(description = "DTO para operações de imóvel")
public class ImovelDto {

    @Schema(description = "ID do imóvel", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Descrição detalhada do imóvel", required = true, 
             example = "Apartamento de 2 quartos com varanda gourmet")
    @NotNull(message = "o campo DESCRIÇÃO é obrigatório")
    @Length(min = 10, max = 200, message = "o campo DESCRIÇÃO deve ter entre 10 e 200 caracteres")
    private String descricao;

    @Schema(description = "Endereço completo do imóvel", 
            example = "Rua Exemplo, 123 - Bairro, Cidade/UF - CEP 12345-678")
    private String endereco;

    public ImovelDto() {
    }

    public ImovelDto(Long id, String descricao, String endereco) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
