package com.example.alugafacil.alugafacil.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AluguelDto {

    private Long id;

    @NotNull(message = "O campo INQUILINO é obrigatório")
    private Long inquilinoId;

    @NotNull(message = "O campo IMÓVEL é obrigatório")
    private Long imovelId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private @NotNull(message = "O campo DATA DE VENCIMENTO é obrigatório")
    LocalDate dataVencimento;

    @NotNull(message = "O campo VALOR é obrigatório")
    @Min(value = 0, message = "O VALOR deve ser maior ou igual a zero")
    private Double valor;

    // Para facilitar a exibição
    private String inquilinoNome;
    private String imovelEndereco;

    public AluguelDto() {
    }

    public AluguelDto(Long id, Long inquilinoId, Long imovelId, @NotNull(message = "O campo DATA DE VENCIMENTO é obrigatório") LocalDate dataVencimento, Double valor) {
        this.id = id;
        this.inquilinoId = inquilinoId;
        this.imovelId = imovelId;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(Long inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }

    public @NotNull(message = "O campo DATA DE VENCIMENTO é obrigatório") LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(@NotNull(message = "O campo DATA DE VENCIMENTO é obrigatório") LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getInquilinoNome() {
        return inquilinoNome;
    }

    public void setInquilinoNome(String inquilinoNome) {
        this.inquilinoNome = inquilinoNome;
    }

    public String getImovelEndereco() {
        return imovelEndereco;
    }

    public void setImovelEndereco(String imovelEndereco) {
        this.imovelEndereco = imovelEndereco;
    }
}
