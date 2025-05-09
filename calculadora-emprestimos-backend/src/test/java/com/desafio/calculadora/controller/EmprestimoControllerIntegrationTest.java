package com.desafio.calculadora.controller;

import com.desafio.calculadora.dto.EmprestimoRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmprestimoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornarParcelasCorretamente() throws Exception {
        EmprestimoRequestDTO req = new EmprestimoRequestDTO();
        req.dataInicial = LocalDate.of(2024, 1, 1);
        req.dataFinal = LocalDate.of(2024, 6, 30);
        req.primeiroPagamento = LocalDate.of(2024, 2, 29);
        req.valorEmprestimo = new BigDecimal("10000");
        req.taxaJuros = new BigDecimal("2");

        mockMvc.perform(post("/api/emprestimos/calcular")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }
}
