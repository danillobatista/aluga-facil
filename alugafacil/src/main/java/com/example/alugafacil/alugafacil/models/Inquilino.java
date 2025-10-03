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
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    private String nome;
    private String email;

    @OneToMany(mappedBy = "inquilino")
    @ToString.Exclude
    private List<Aluguel> alugueis = new ArrayList<>();

    public Inquilino(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
