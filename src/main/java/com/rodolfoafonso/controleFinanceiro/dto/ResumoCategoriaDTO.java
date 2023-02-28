package com.rodolfoafonso.controleFinanceiro.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ResumoCategoriaDTO  {
    private BigDecimal valor;
    private String categoria;


    public ResumoCategoriaDTO( BigDecimal valor, String categoria) {
        this.valor = valor;
        this.categoria = categoria;
    }
}
