package com.example.alugafacil.alugafacil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imovel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String descricao;
    private String endereco;
}
