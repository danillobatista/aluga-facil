package com.example.alugafacil.alugafacil.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;
    private String endereco;

    @OneToMany(mappedBy = "imovel")
    @ToString.Exclude
    private List<Aluguel> alugueis = new ArrayList<>();


    public Imovel(String descricao, String endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
    }
}
