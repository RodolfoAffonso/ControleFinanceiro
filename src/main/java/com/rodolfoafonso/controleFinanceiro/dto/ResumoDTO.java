package com.rodolfoafonso.controleFinanceiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@Setter
@Getter
public class ResumoDTO {


    private BigDecimal valorTotalReceita;
    private BigDecimal valorTotalDespesa;

    private BigDecimal ResumodoMes;

    private List<ResumoCategoriaDTO> categorias ;

}
