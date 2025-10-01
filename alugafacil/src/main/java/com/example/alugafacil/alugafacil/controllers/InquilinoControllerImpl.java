package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.InquilinoController;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.dtos.InquilinoDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.models.Inquilino;
import com.example.alugafacil.alugafacil.services.InquilinoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoControllerImpl implements InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @GetMapping
    public ResponseEntity<List<InquilinoDto>> findAll() {
        List<Inquilino> inquilinos = inquilinoService.findAll();

        return ResponseEntity
                .ok()
                .body(inquilinos.stream().map(obj -> modelMapper.map(obj, InquilinoDto.class)).collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    public ResponseEntity<InquilinoDto> save(@Valid @RequestBody InquilinoDto inquilinoDto){
        Inquilino inquilino = inquilinoService.save(modelMapper.map(inquilinoDto, Inquilino.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(inquilino.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(inquilino, InquilinoDto.class));
    }
}
