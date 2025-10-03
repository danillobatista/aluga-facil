package com.example.alugafacil.alugafacil.controllers.interfaces;

import com.example.alugafacil.alugafacil.dtos.AluguelDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AluguelController {
    public ResponseEntity<List<AluguelDto>> findAll();
    public ResponseEntity<AluguelDto> save(AluguelDto aluguelDto);
    public ResponseEntity<Void> pay(Long id);
}
