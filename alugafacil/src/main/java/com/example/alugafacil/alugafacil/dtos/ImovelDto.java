package com.example.alugafacil.alugafacil.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class ImovelDto {

    private Integer id;

    @NotNull(message = "o campo DESCRIÇÃO é obrigatório")
    @Length(min = 10, max = 200, message = "o campo DESCRIÇÃO deve ter entre 10 e 200 caracteres")
    private String descricao;

    private String endereco;

}
