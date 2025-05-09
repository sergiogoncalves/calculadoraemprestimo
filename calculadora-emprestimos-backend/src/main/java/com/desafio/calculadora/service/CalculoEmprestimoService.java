package com.desafio.calculadora.service;

import com.desafio.calculadora.dto.EmprestimoRequestDTO;
import com.desafio.calculadora.dto.ParcelaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculoEmprestimoService {

    public List<ParcelaDTO> calcularParcelas(EmprestimoRequestDTO request);
}
