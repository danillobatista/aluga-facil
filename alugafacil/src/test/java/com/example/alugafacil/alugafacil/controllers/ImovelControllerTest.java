package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.dtos.ImovelDto;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.services.ImovelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ImovelControllerTest {

    @Mock
    private ImovelService imovelService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ImovelControllerImpl imovelController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Imovel imovel;
    private ImovelDto imovelDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(imovelController).build();
        objectMapper = new ObjectMapper();
        
        imovel = new Imovel();
        imovel.setId(1L);
        imovel.setDescricao("Apartamento com 2 quartos");
        imovel.setEndereco("Rua Teste, 123");
        
        imovelDto = new ImovelDto();
        imovelDto.setId(1L);
        imovelDto.setDescricao("Apartamento com 2 quartos");
        imovelDto.setEndereco("Rua Teste, 123");
    }

    @Test
    void save_WhenValidInput_ReturnsCreated() throws Exception {
        // Arrange
        when(modelMapper.map(any(ImovelDto.class), eq(Imovel.class))).thenReturn(imovel);
        when(imovelService.save(any(Imovel.class))).thenReturn(imovel);
        when(modelMapper.map(any(Imovel.class), eq(ImovelDto.class))).thenReturn(imovelDto);

        // Act & Assert
        mockMvc.perform(post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovelDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.descricao").value("Apartamento com 2 quartos"))
                .andExpect(jsonPath("$.endereco").value("Rua Teste, 123"));

        verify(imovelService, times(1)).save(any(Imovel.class));
    }
}
