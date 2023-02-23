package com.rodolfoafonso.controleFinanceiro.dto;

import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ReceitaDTO {

    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    public ReceitaDTO(Long id, String descricao, BigDecimal valor, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }


    public ReceitaDTO(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }
}
