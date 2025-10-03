package com.example.alugafacil.alugafacil.controllers.interfaces;

import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.dtos.InquilinoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InquilinoController {
    public ResponseEntity<InquilinoDto> save(InquilinoDto inquilinoDto);
}
