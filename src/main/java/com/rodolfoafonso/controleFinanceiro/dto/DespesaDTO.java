package com.rodolfoafonso.controleFinanceiro.dto;

import com.rodolfoafonso.controleFinanceiro.entity.Despesa;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@Getter
public class DespesaDTO {
    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    private String categoria ;

    public DespesaDTO(Long id, String descricao, BigDecimal valor, LocalDate data, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }


    public DespesaDTO(Despesa despesa) {
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
        this.categoria = despesa.getCategoria().toString();
    }
}
