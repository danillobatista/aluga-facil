package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.InquilinoController;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.dtos.InquilinoDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.models.Inquilino;
import com.example.alugafacil.alugafacil.services.InquilinoService;
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
@RequestMapping(value = "/inquilinos", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Inquilinos", description = "API para gerenciamento de inquilinos")
public class InquilinoControllerImpl implements InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastrar um novo inquilino", description = "Cria um novo registro de inquilino no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Inquilino cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<InquilinoDto> save(@Valid @RequestBody InquilinoDto inquilinoDto) {
        Inquilino inquilino = inquilinoService.save(modelMapper.map(inquilinoDto, Inquilino.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(inquilino.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(inquilino, InquilinoDto.class));
    }
}
