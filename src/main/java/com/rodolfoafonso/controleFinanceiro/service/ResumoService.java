package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.dto.ReceitaDTO;
import com.rodolfoafonso.controleFinanceiro.dto.ResumoDTO;
import com.rodolfoafonso.controleFinanceiro.entity.Despesa;
import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import com.rodolfoafonso.controleFinanceiro.repository.DespesaRepository;
import com.rodolfoafonso.controleFinanceiro.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ResumoService {

    ReceitaRepository receitaRepository ;
    DespesaRepository despesaRepository ;


    public ResumoDTO resumoDoMes(int ano, int mes) {

    }
}
