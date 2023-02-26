package com.rodolfoafonso.controleFinanceiro.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Receita{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descricao;

        private BigDecimal valor;

        private LocalDate data;


        public Receita(Long id, String descricao, BigDecimal valor, LocalDate data ) {
            this.id = id;
            this.descricao = descricao;
            this.valor = valor;
            this.data = data;
        }
}
