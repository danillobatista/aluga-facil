package com.example.alugafacil.alugafacil.services;

import com.example.alugafacil.alugafacil.exceptions.ObjectNotFoundException;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }

    public Imovel save(Imovel imovel){
        return imovelRepository.save(imovel);
    }
}
