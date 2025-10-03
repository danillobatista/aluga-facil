package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.dtos.InquilinoDto;
import com.example.alugafacil.alugafacil.models.Inquilino;
import com.example.alugafacil.alugafacil.services.InquilinoService;
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
class InquilinoControllerTest {

    @Mock
    private InquilinoService inquilinoService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private InquilinoControllerImpl inquilinoController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Inquilino inquilino;
    private InquilinoDto inquilinoDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(inquilinoController).build();
        objectMapper = new ObjectMapper();
        
        inquilino = new Inquilino();
        inquilino.setId(1L);
        inquilino.setNome("João da Silva");
        inquilino.setEmail("joao.silva@example.com");
        
        inquilinoDto = new InquilinoDto();
        inquilinoDto.setId(1L);
        inquilinoDto.setNome("João da Silva");
        inquilinoDto.setEmail("joao.silva@example.com");
    }

    @Test
    void save_WhenValidInput_ReturnsCreated() throws Exception {
        // Arrange
        when(modelMapper.map(any(InquilinoDto.class), eq(Inquilino.class))).thenReturn(inquilino);
        when(inquilinoService.save(any(Inquilino.class))).thenReturn(inquilino);
        when(modelMapper.map(any(Inquilino.class), eq(InquilinoDto.class))).thenReturn(inquilinoDto);

        // Act & Assert
        mockMvc.perform(post("/inquilinos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inquilinoDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("João da Silva"))
                .andExpect(jsonPath("$.email").value("joao.silva@example.com"));

        verify(inquilinoService, times(1)).save(any(Inquilino.class));
    }

    @Test
    void save_WhenInvalidEmail_ReturnsBadRequest() throws Exception {
        // Arrange
        inquilinoDto.setEmail("email-invalido");

        // Act & Assert
        mockMvc.perform(post("/inquilinos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inquilinoDto)))
                .andExpect(status().isBadRequest());

        verify(inquilinoService, never()).save(any(Inquilino.class));
    }
}
