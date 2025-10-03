package com.example.alugafacil.alugafacil.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "DTO para operações de aluguel")
public class AluguelDto {

    @Schema(description = "ID do aluguel", example = "1")
    private Long id;

    @Schema(description = "ID do inquilino associado ao aluguel", example = "1")
    private Long inquilinoId;

    @Schema(description = "ID do imóvel alugado", required = true, example = "1")
    @NotNull(message = "O campo IMÓVEL é obrigatório")
    private Long imovelId;

    @Schema(description = "Data de vencimento do aluguel", type = "string", format = "date", example = "2023-12-31")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    @Schema(description = "Valor do aluguel", required = true, example = "1500.00")
    @NotNull(message = "O campo VALOR é obrigatório")
    private Double valor;

    @Schema(description = "Nome do inquilino (apenas leitura)", accessMode = Schema.AccessMode.READ_ONLY)
    private String inquilinoNome;
    
    @Schema(description = "Endereço do imóvel (apenas leitura)", accessMode = Schema.AccessMode.READ_ONLY)
    private String imovelEndereco;

    @Schema(description = "Dias em atraso (apenas leitura)", accessMode = Schema.AccessMode.READ_ONLY, example = "0")
    private int diasEmAtraso;

    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(int diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

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
