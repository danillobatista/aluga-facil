package com.example.alugafacil.alugafacil.controllers.interfaces;

import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImovelController {
    public ResponseEntity<List<ImovelDto>> findAll();
    public ResponseEntity<ImovelDto> save(ImovelDto imovelDto);
//    public ResponseEntity<ImovelDto> save(ImovelDto imovelDto);
}
