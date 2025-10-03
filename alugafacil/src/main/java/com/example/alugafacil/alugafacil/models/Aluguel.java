package com.example.alugafacil.alugafacil.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    @ToString.Exclude
    private Inquilino inquilino;
    
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    @ToString.Exclude
    private Imovel imovel;
    
    private LocalDate dataVencimento;
    private double valor;

    public void setPago() {
        this.dataVencimento = this.dataVencimento.plusMonths(1);
    }
}
