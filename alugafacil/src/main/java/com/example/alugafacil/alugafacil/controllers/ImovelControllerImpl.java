package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.ImovelController;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.services.ImovelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/imoveis", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Imóveis", description = "API para gerenciamento de imóveis")
public class ImovelControllerImpl implements ImovelController {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastrar um novo imóvel", description = "Cria um novo registro de imóvel no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Imóvel cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<ImovelDto> save(@Valid @RequestBody ImovelDto imovelDto) {
        Imovel imovel = imovelService.save(modelMapper.map(imovelDto, Imovel.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(imovel.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(imovel, ImovelDto.class));
    }
}
