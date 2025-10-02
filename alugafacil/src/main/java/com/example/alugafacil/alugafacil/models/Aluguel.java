package com.example.alugafacil.alugafacil.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private Inquilino inquilino;
    
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    private LocalDate dataVencimento;
    private double valor;

    public Aluguel() {}

    public Aluguel(Long id, Inquilino inquilino, Imovel imovel, LocalDate dataVencimento, double valor) {
        this.id = id;
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }
    
    public Aluguel(Inquilino inquilino, Imovel imovel, LocalDate dataVencimento, double valor) {
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    // Getters e Setters
    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", inquilino=" + inquilino +
                ", imovel=" + imovel +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                '}';
    }
}
