package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.controllers.interfaces.AluguelController;
import com.example.alugafacil.alugafacil.dtos.AluguelDto;
import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Aluguel;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.services.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/alugueis", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Aluguéis", description = "API para gerenciamento de aluguéis de imóveis")
public class AluguelControllerImpl implements AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar um novo aluguel", description = "Registra um novo contrato de aluguel no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Aluguel criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
        @ApiResponse(responseCode = "404", description = "Imóvel ou inquilino não encontrado")
    })
    public ResponseEntity<AluguelDto> save(@Valid @RequestBody AluguelDto aluguelDto) {
        System.out.println("DATA RECEBIDA: " + aluguelDto);

        Aluguel aluguel = aluguelService.save(modelMapper.map(aluguelDto, Aluguel.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Pega a URI atual: /imoveis
                .path("/{id}")        // Adiciona o caminho do ID: /imoveis/{id}
                .buildAndExpand(aluguel.getId()) // Preenche o {id} com o ID real
                .toUri();

        return ResponseEntity.created(location).body(modelMapper.map(aluguel, AluguelDto.class));
    }

    @Override
    @PatchMapping("/{id}/pagar")
    @Operation(summary = "Registrar pagamento de aluguel", description = "Registra o pagamento de um aluguel existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "ID inválido fornecido"),
        @ApiResponse(responseCode = "404", description = "Aluguel não encontrado")
    })
    public ResponseEntity<Void> pay(
        @Parameter(description = "ID do aluguel a ser pago", required = true, example = "1")
        @PathVariable Long id) {
        aluguelService.pagar(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/atrasados")
    @Operation(summary = "Listar aluguéis em atraso", description = "Retorna a lista de aluguéis que estão com pagamento em atraso")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de aluguéis em atraso retornada com sucesso")
    })
    public ResponseEntity<List<AluguelDto>> late() {
        List<Aluguel> alugueisAtrasados = aluguelService.findLate();

        List<AluguelDto> listaAlugueisAtrasadosDto = new ArrayList<>();

        for (Aluguel aluguel : alugueisAtrasados) {
            AluguelDto aluguelDto = modelMapper.map(aluguel, AluguelDto.class);
            aluguelDto.setDiasEmAtraso(aluguel.getDataVencimento().until(LocalDate.now()).getDays());
            listaAlugueisAtrasadosDto.add(aluguelDto);
        }

        return ResponseEntity
                .ok()
                .body(listaAlugueisAtrasadosDto);
    }
}
