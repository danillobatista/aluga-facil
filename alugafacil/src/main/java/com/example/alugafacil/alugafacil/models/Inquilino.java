package com.example.alugafacil.alugafacil.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "inquilino")
    private List<Aluguel> alugueis;

    public Inquilino() {
        this.alugueis = new ArrayList<>();
    }

    public Inquilino(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino inquilino = (Inquilino) o;
        return id.equals(inquilino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email);
    }
}
