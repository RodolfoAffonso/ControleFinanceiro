package com.rodolfoafonso.controleFinanceiro.controller;

import com.rodolfoafonso.controleFinanceiro.dto.ReceitaDTO;
import com.rodolfoafonso.controleFinanceiro.dto.ResumoDTO;
import com.rodolfoafonso.controleFinanceiro.service.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/resumo")
@RestController
public class ResumoController {

    @Autowired
    ResumoService resumoService ;

    @GetMapping("/{ano}/{mes}")
    public ResumoDTO buscarReceitaMes(@PathVariable int ano, @PathVariable int mes){
        return resumoService.resumoDoMes(ano,mes);
    }
}
