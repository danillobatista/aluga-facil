package com.example.alugafacil.alugafacil.repositories;

import com.example.alugafacil.alugafacil.models.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
