package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.AluguelController;
import com.example.alugafacil.alugafacil.dtos.AluguelDto;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Aluguel;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.services.AluguelService;
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
@RequestMapping("/alugueis")
public class AluguelControllerImpl implements AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @GetMapping
    public ResponseEntity<List<AluguelDto>> findAll() {
        List<Aluguel> alugueis = aluguelService.findAll();

        return ResponseEntity
                .ok()
                .body(alugueis.stream().map(obj -> modelMapper.map(obj, AluguelDto.class)).collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    public ResponseEntity<AluguelDto> save(@Valid @RequestBody AluguelDto aluguelDto){
        System.out.println("DATA RECEBIDA: " + aluguelDto);

        Aluguel aluguel = aluguelService.save(modelMapper.map(aluguelDto, Aluguel.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(aluguel.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(aluguel, AluguelDto.class));
    }
}
