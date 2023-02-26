package com.rodolfoafonso.controleFinanceiro.dto;

import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    public static List<ReceitaDTO> getReceitaDTOS(List<Receita> receitas) {
        return receitas.stream().map(receita -> new ReceitaDTO(receita.getId(), receita.getDescricao(), receita.getValor(), receita.getData())).toList();
    }

}
