package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.ImovelController;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.services.ImovelService;
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
@RequestMapping("/imoveis")
public class ImovelControllerImpl implements ImovelController {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @GetMapping
    public ResponseEntity<List<ImovelDto>> findAll() {
        List<Imovel> imoveis = imovelService.findAll();

        return ResponseEntity
                .ok()
                .body(imoveis.stream().map(obj -> modelMapper.map(obj, ImovelDto.class)).collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    public ResponseEntity<ImovelDto> save(@Valid @RequestBody ImovelDto imovelDto){
        Imovel imovel = imovelService.save(modelMapper.map(imovelDto, Imovel.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(imovel.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(imovel, ImovelDto.class));
    }
}
