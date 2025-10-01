package com.example.alugafacil.alugafacil.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    public Inquilino() {}

    public Inquilino(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", descricao='" + nome + '\'' +
                ", endereco='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino imovel = (Inquilino) o;
        return Objects.equals(id, imovel.id) && Objects.equals(nome, imovel.nome) && Objects.equals(email, imovel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email);
    }
}
