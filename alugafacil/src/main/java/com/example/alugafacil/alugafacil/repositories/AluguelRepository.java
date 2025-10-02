package com.example.alugafacil.alugafacil.repositories;

import com.example.alugafacil.alugafacil.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
