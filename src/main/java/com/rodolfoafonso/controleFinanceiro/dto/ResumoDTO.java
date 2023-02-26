package com.rodolfoafonso.controleFinanceiro.dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
public class ResumoDTO {


    private BigDecimal valorTotalReceita;
    private BigDecimal valorTotalDespesa;

    private BigDecimal ResumodoMes;

    private List<ResumoCategoriaDTO> categorias ;

}
