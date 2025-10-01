package com.example.alugafacil.alugafacil.repositories;

import com.example.alugafacil.alugafacil.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
