package com.example.alugafacil.alugafacil.services;

import com.example.alugafacil.alugafacil.exceptions.ObjectNotFoundException;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.models.Inquilino;
import com.example.alugafacil.alugafacil.repositories.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    public List<Inquilino> findAll() {
        return inquilinoRepository.findAll();
    }

    public Inquilino save(Inquilino inquilino){
        return inquilinoRepository.save(inquilino);
    }

}
