package com.example.alugafacil.alugafacil.services;

import com.example.alugafacil.alugafacil.exceptions.ObjectNotFoundException;
import com.example.alugafacil.alugafacil.models.Aluguel;
import com.example.alugafacil.alugafacil.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Aluguel> findAll() {
        return aluguelRepository.findAll();
    }

    public Aluguel save(Aluguel aluguel){
        if(aluguel.getValor() <= 0)
            throw new IllegalArgumentException("Valor negativo ou inválido");



        return aluguelRepository.save(aluguel);
    }

    public void pagar(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluguel não encontrado."));

        aluguel.setPago();
        aluguelRepository.save(aluguel);
    }
}
