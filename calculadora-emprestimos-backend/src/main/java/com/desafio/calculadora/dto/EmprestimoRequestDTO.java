package com.desafio.calculadora.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class EmprestimoRequestDTO {
    public LocalDate dataInicial;
    public LocalDate dataFinal;
    public LocalDate primeiroPagamento;
    public BigDecimal valorEmprestimo;
    public BigDecimal taxaJuros;
}
