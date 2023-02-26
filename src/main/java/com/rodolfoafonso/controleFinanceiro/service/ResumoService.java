package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.dto.ResumoCategoriaDTO;
import com.rodolfoafonso.controleFinanceiro.dto.ResumoDTO;
import com.rodolfoafonso.controleFinanceiro.repository.DespesaRepository;
import com.rodolfoafonso.controleFinanceiro.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class ResumoService {

    ReceitaRepository receitaRepository ;
    DespesaRepository despesaRepository ;


    public ResumoDTO resumoDoMes(int ano, int mes) {
        BigDecimal totalReceitaMes = receitaRepository.resumoMes(ano, mes) ;
        List<ResumoCategoriaDTO> totalCategoriaDespesa = despesaRepository.resumoMes(ano, mes) ;
        BigDecimal totalDespesames = BigDecimal.ZERO;
        for ( ResumoCategoriaDTO resumoCategoriaDTO: totalCategoriaDespesa) {
            totalDespesames = totalDespesames.add(resumoCategoriaDTO.getValor()) ;
        }
        BigDecimal balancoMes = totalReceitaMes.subtract(totalDespesames)  ;
        ResumoDTO resumoDTO = new ResumoDTO(totalReceitaMes,totalDespesames,balancoMes,totalCategoriaDespesa);
        return resumoDTO ;


    }
}
