package com.desafio.calculadora.controller;

import com.desafio.calculadora.dto.EmprestimoRequestDTO;
import com.desafio.calculadora.dto.ParcelaDTO;
import com.desafio.calculadora.service.CalculoEmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    private final CalculoEmprestimoService service;

    public EmprestimoController(CalculoEmprestimoService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public List<ParcelaDTO> calcular(@RequestBody EmprestimoRequestDTO request) {
        return service.calcularParcelas(request);
    }
}