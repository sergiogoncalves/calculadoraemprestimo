package com.desafio.calculadora.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ParcelaDTO {
    public LocalDate data;
    public BigDecimal parcela;
    public BigDecimal juros;
    public BigDecimal amortizacao;
    public BigDecimal saldo;
}
