package com.example.alugafacil.alugafacil.controllers;

import com.example.alugafacil.alugafacil.dtos.AluguelDto;
import com.example.alugafacil.alugafacil.models.Aluguel;
import com.example.alugafacil.alugafacil.services.AluguelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.alugafacil.alugafacil.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(MockitoExtension.class)
class AluguelControllerTest {

    @Mock
    private AluguelService aluguelService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AluguelControllerImpl aluguelController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Aluguel aluguel;
    private AluguelDto aluguelDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(aluguelController).build();
        objectMapper = new ObjectMapper();
        
        aluguel = new Aluguel();
        aluguel.setId(1L);
        aluguel.setValor(1500.0);
        aluguel.setDataVencimento(LocalDate.now().plusDays(10));
        
        aluguelDto = new AluguelDto();
        aluguelDto.setId(1L);
        aluguelDto.setValor(1500.0);
        aluguelDto.setDataVencimento(LocalDate.now().plusDays(10));
    }

    @Test
    void save_WhenValidInput_ReturnsCreated() throws Exception {
        // Arrange
        when(modelMapper.map(any(AluguelDto.class), eq(Aluguel.class))).thenReturn(aluguel);
        when(aluguelService.save(any(Aluguel.class))).thenReturn(aluguel);
        when(modelMapper.map(any(Aluguel.class), eq(AluguelDto.class))).thenReturn(aluguelDto);

        // Act & Assert
        mockMvc.perform(post("/alugueis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aluguelDto)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.valor").value(1500.0));

        verify(aluguelService, times(1)).save(any(Aluguel.class));
    }
    
    @Test
    void save_WhenInvalidInput_ReturnsBadRequest() throws Exception {
        // Arrange
        aluguelDto.setValor(0.0); // Valor inválido
        
        // Act & Assert
        ResultActions result = mockMvc.perform(post("/alugueis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aluguelDto)))
                .andExpect(status().isBadRequest());

        // Verifica se a mensagem de erro contém o campo inválido
        result.andExpect(result1 -> 
            assertTrue(result1.getResolvedException() instanceof MethodArgumentNotValidException));
                
        verify(aluguelService, never()).save(any(Aluguel.class));
    }
    
    @Test
    void save_WhenNullInput_ReturnsBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/alugueis")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors", hasSize(greaterThan(0))));
                
        verify(aluguelService, never()).save(any(Aluguel.class));
    }

    @Test
    void pay_WhenValidId_ReturnsOk() throws Exception {
        // Arrange
        doNothing().when(aluguelService).pagar(anyLong());

        // Act & Assert
        mockMvc.perform(patch("/alugueis/1/pagar"))
                .andExpect(status().isOk());

        verify(aluguelService, times(1)).pagar(1L);
    }
    
    @Test
    void pay_WhenNonExistentId_ReturnsNotFound() throws Exception {
        // Arrange
        Long nonExistentId = 999L;
        doThrow(new ObjectNotFoundException("Aluguel não encontrado."))
            .when(aluguelService).pagar(nonExistentId);

        // Act & Assert
        mockMvc.perform(patch("/alugueis/" + nonExistentId + "/pagar"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message").value("Aluguel não encontrado."));

        verify(aluguelService, times(1)).pagar(nonExistentId);
    }
    
    @Test
    void pay_WhenInvalidIdFormat_ReturnsBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(patch("/alugueis/abc/pagar"))
                .andExpect(status().isBadRequest());
                
        verify(aluguelService, never()).pagar(anyLong());
    }

    @Test
    void late_WhenCalled_ReturnsOk() throws Exception {
        // Arrange
        when(aluguelService.findLate()).thenReturn(List.of(aluguel));
        when(modelMapper.map(any(Aluguel.class), eq(AluguelDto.class))).thenReturn(aluguelDto);

        // Act & Assert
        mockMvc.perform(get("/alugueis/atrasados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1L));

        verify(aluguelService, times(1)).findLate();
    }
    
    @Test
    void late_WhenNoLateRentals_ReturnsEmptyList() throws Exception {
        // Arrange
        when(aluguelService.findLate()).thenReturn(List.of());

        // Act & Assert
        mockMvc.perform(get("/alugueis/atrasados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(aluguelService, times(1)).findLate();
    }
}
