package com.rodolfoafonso.controleFinanceiro.repository;


import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {


    @Query("SELECT count(*)  FROM Receita r WHERE r.descricao = :descricao and Month(data) = Month(:data)")
    Long verificaCondicao(@Param("descricao") String descricao, @Param("data") LocalDate data);


    List<Receita> findByDescricao(String descricao);

    @Query("SELECT r FROM Receita r WHERE Year(data) = :ano  and Month(data) = :mes")
    List<Receita> buscaMes(@Param("ano") int ano , @Param("mes") int mes);

}
