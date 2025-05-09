package com.desafio.calculadora.service;

import com.desafio.calculadora.dto.EmprestimoRequestDTO;
import com.desafio.calculadora.dto.ParcelaDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalculoEmprestimoServiceImpl implements CalculoEmprestimoService {
    @Override
    public List<ParcelaDTO> calcularParcelas(EmprestimoRequestDTO request) {
        List<ParcelaDTO> parcelas = new ArrayList<>();

        long meses = java.time.temporal.ChronoUnit.MONTHS.between(
                request.primeiroPagamento.withDayOfMonth(1),
                request.dataFinal.withDayOfMonth(1)) + 1;

        BigDecimal taxaMensal = request.taxaJuros.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal parcela = request.valorEmprestimo.multiply(
                        taxaMensal.multiply(BigDecimal.ONE.add(taxaMensal).pow((int) meses)))
                .divide(BigDecimal.ONE.add(taxaMensal).pow((int) meses).subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

        BigDecimal saldo = request.valorEmprestimo;

        for (int i = 0; i < meses; i++) {
            LocalDate data = request.primeiroPagamento.plusMonths(i);
            BigDecimal juros = saldo.multiply(taxaMensal).setScale(2, RoundingMode.HALF_UP);
            BigDecimal amortizacao = parcela.subtract(juros).setScale(2, RoundingMode.HALF_UP);
            saldo = saldo.subtract(amortizacao).setScale(2, RoundingMode.HALF_UP);

            ParcelaDTO p = new ParcelaDTO();
            p.data = data;
            p.parcela = parcela;
            p.juros = juros;
            p.amortizacao = amortizacao;
            p.saldo = saldo.max(BigDecimal.ZERO);

            parcelas.add(p);
        }

        return parcelas;
    }
}
