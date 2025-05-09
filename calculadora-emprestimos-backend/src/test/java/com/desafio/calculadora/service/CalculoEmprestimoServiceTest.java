package com.desafio.calculadora.service;

import com.desafio.calculadora.dto.EmprestimoRequestDTO;
import com.desafio.calculadora.dto.ParcelaDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculoEmprestimoServiceTest {

    CalculoEmprestimoService service = new CalculoEmprestimoServiceImpl();

    @Test
    void deveCalcularParcelasCorretamente() {
        EmprestimoRequestDTO req = new EmprestimoRequestDTO();
        req.dataInicial = LocalDate.of(2024, 1, 1);
        req.dataFinal = LocalDate.of(2024, 6, 30);
        req.primeiroPagamento = LocalDate.of(2024, 2, 29);
        req.valorEmprestimo = new BigDecimal("10000");
        req.taxaJuros = new BigDecimal("2");

        List<ParcelaDTO> parcelas = service.calcularParcelas(req);

        assertEquals(5, parcelas.size());
        assertNotNull(parcelas.get(0).parcela);
        assertTrue(parcelas.get(0).parcela.compareTo(BigDecimal.ZERO) > 0);
    }
}